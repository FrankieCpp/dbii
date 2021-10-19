package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;

import dbii.database_framework.crud.Crud;
import dbii.database_framework.crud.enums.Dbms;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlManager;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import dbii.database_framework.utils.DbmsFactory;
import dto.JsonResponse;
import dto.JspAttribute;
import labels.LabelManager;
import model.Users;
import utils.Helpers;
import utils.ResponseType;

public abstract class ControllerBase extends HttpServlet {
	public static final long serialVersionUID = 1L;

	public static Crud crud;
	public static SqlManager sql;

	protected final static String USERID = "usid";
	protected final static String SESSION_KEY = "sessionkey";

	private static LabelManager labelManager;
	private static Logger logger;

	/***********************************
	 * SERVLET METHODS
	 **********************************/
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.innerInit(config);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	/**********************************/
	/**
	 * setControllerValidation
	 * checks cookie values 
	 * @param request
	 * @return
	 */
	protected boolean setControllerValidation(HttpServletRequest request) {
		boolean foundUsername = false;
		boolean foundSessionKey = false;
		String usernameStr = null;
		String sessionKeyStr = null;
		int i = 0;
		boolean res = false;
		Cookie[] cookies = request.getCookies();
		while((!foundUsername || !foundSessionKey) && i < cookies.length) {
			Cookie temp = cookies[i];
			if(USERID.equals(temp.getName())){
				foundUsername = true;
				usernameStr = temp.getValue();
			}
			if(SESSION_KEY.equals(temp.getName())){
				foundSessionKey = true;
				sessionKeyStr = temp.getValue();
			}
			i++;
		}
		write(getLabel("COOKIE") + ": " + usernameStr);
		write(getLabel("COOKIE") + ": " + sessionKeyStr);

		SqlValue username = new SqlValue(ValueType.STRING,usernameStr);
		try {
			List<Users> list = crud.read(sql.getQuery(Users.class,"GET_USER", username));
			res = !Helpers.isStringEmpty(sessionKeyStr) && sessionKeyStr.equals(list.get(0).getSessionKey());
		} catch (Exception e) {
			write(e.getMessage(),e);
			res = false;
		}
		if(res)
			write(getLabel("VALIDATION_COOKIE_OK"));
		return res;
	}

	protected Map<String,String> getDataFromView(HttpServletRequest request, Class<?> classe){
		Map<String,String> res = new HashMap<String,String>();
		Field[] fields = classe.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			try{
				Field field = fields[i];
				String fieldValue = (String)field.get(null);
				String value = request.getParameter(fieldValue);
				write(getLabel("PARAMETER")+ " "+fieldValue + ": " + value);
				res.put(fieldValue, value);
			} catch(Exception e){
				write(getLabel("ERROR_IN_DATA_READING"));
			}
		}
		return res;
	}
	/*************************************
	 * ABSTRACTS METHODS
	 *************************************/
	abstract public String getServletName(); 

	abstract public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract ResponseType getResponseType();
	/***********************************
	 * LABELS
	 **********************************/
	public static synchronized String getLabel(String label){
		return labelManager.get(label);
	}

	public static synchronized String getParametrizedLabel(String label,String...values){
		String res = "";
		try {
			return labelManager.getParametrized(label,values);
		} catch (DbmsException e) {
			res = getLabel("ERROR_IN_STRING_CONVERSION");
		}
		return res;
	}

	/***********************************
	 * LOGS
	 **********************************/
	public static synchronized void write(String message){
		logger.info(message);
	}

	public static synchronized void write(String message, Exception e){
		logger.info(message, e);
	}

	protected void directTo(HttpServletRequest request, HttpServletResponse response, String goTo, JspAttribute... attributes) throws ServletException, IOException {
		if(attributes != null){
			for(int i = 0; i < attributes.length;i++){
				JspAttribute<?> temp = attributes[i];
				request.setAttribute(temp.getName(), temp.getObject());
			}
		}
		request.getRequestDispatcher(goTo).forward(request, response);
	}
	/***********************************
	 * JSON
	 **********************************/
	protected void setJsonResponse(HttpServletResponse response, String code, String msg) throws IOException{
		response.setContentType("application/json");
		JsonResponse res = new JsonResponse(code,msg);
		Gson gson = new Gson();
		String json = gson.toJson(res);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
	
	protected void setJsonResponse(HttpServletResponse response, JsonResponse resp) throws IOException{
		response.setContentType("application/json");
		Gson gson = new Gson();
		String json = gson.toJson(resp);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
	/************************************
	 * PRIVATE METHODS
	 ************************************/
	private synchronized void process(HttpServletRequest request, HttpServletResponse response){
		boolean validate = false;
		try{
			validate = this.setControllerValidation(request);
			if(validate){				
				write(labelManager.get("RUN_CONTROLLER") + ": " + this.getServletName());
				this.processRequest(request, response);		
				write(labelManager.get("CONTROLLER_OK") + ": " + this.getServletName());
			}
		} 
		catch(Exception e){
			write(labelManager.get("CONTROLLER_KO") + ": " + e.getMessage());
			validate = false;
		}

		try{
			if(!validate){
				if(getResponseType() == ResponseType.JSP){
					this.directTo(request, response, "WEB-INF/templates/errorPage.jsp");
				} else {
					setJsonResponse(response, "-1", getLabel("GENERIC_ERROR"));
				}
			}
		} 
		catch(Exception e){
			write(e.getMessage(),e);
		}
	}

	private synchronized void innerInit(ServletConfig config){
		try {
			if(ControllerBase.logger == null){
				String log4jLocation = config.getInitParameter("log4j-properties-location");

				ServletContext sc = config.getServletContext();

				String webAppPath = sc.getRealPath("/");
				String log4jProp = webAppPath + log4jLocation;
				File output = new File(log4jProp);

				PropertyConfigurator.configure(log4jProp);

				Properties p = new Properties();
				p.load(new FileInputStream(output.getAbsolutePath()));
				PropertyConfigurator.configure(p);

				ControllerBase.logger = Logger.getLogger(ControllerBase.class);
				ControllerBase.logger.error("Log Inizializzato");
			}
			if(ControllerBase.labelManager == null){				
				ControllerBase.labelManager = LabelManager.getInstance();	
			}
			if(ControllerBase.crud == null) {
				ControllerBase.crud = DbmsFactory.getInstance(Dbms.ORACLE);
				ControllerBase.sql = crud.getSqlManager();
				//this.generate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException(e);
		}
	}
	
	private void  generate() throws DbmsException{
		List<String> soci = new LinkedList<String>();
		List<String> modelli = new LinkedList<String>();
		List<String> imbarcazioni = new LinkedList<String>();
		List<String> personale = new LinkedList<String>();
		List<String> tecnico = new LinkedList<String>();
		List<String> test = new LinkedList<String>();
		List<String> testEseguiti = new LinkedList<String>();

		//SOCI
		for(int i = 0; i < 10; i++){
			String socio = DataHelpers.generateCode();
			soci.add(socio);
			SqlValue nameSql = new SqlValue(ValueType.STRING, socio);
			test.add(sql.getDml("INSERIMENTO_SOCIO", nameSql).getSql());
		}


		//MODELLO

		for(int i = 0; i < 10; i++){
			String ids = DataHelpers.generateRandomString(10);
			modelli.add(ids);
			SqlValue dato1 = new SqlValue(ValueType.STRING, ids);
			SqlValue dato2 = new SqlValue(ValueType.INT, DataHelpers.getNubmer(10));
			SqlValue dato3 = new SqlValue(ValueType.INT, DataHelpers.getNubmer(10));
			SqlValue dato4 = new SqlValue(ValueType.INT, DataHelpers.getNubmer(10));

			test.add(sql.getDml("INSERIMENTO_MODELLO", dato1,dato2,dato3,dato4).getSql());
		}


		//IMBARCAZIONE
		for(int i = 0; i < 10; i++){
			String id = DataHelpers.generateRandomString(10);
			imbarcazioni.add(id);

			SqlValue dato1 = new SqlValue(ValueType.STRING, id);
			SqlValue dato2 = new SqlValue(ValueType.STRING, modelli.get(i));
			SqlValue dato3 = new SqlValue(ValueType.STRING, soci.get(i));
			test.add(sql.getDml("INSERIMENTO_IMBARCAZIONE", dato1,dato2,dato3).getSql());
		}


		// PERSONALE MARITTIMO
		for(int i = 0; i < 10; i++){
			String id = DataHelpers.generateCode();
			personale.add(id);
			SqlValue dato1 = new SqlValue(ValueType.STRING, id);
			SqlValue dato2 = new SqlValue(ValueType.STRING, DataHelpers.nomi.get(i));
			SqlValue dato3 = new SqlValue(ValueType.STRING, DataHelpers.cognomi.get(i));
			SqlValue dato4 = new SqlValue(ValueType.STRING, DataHelpers.generateRandomString(10));
			SqlValue dato5 = new SqlValue(ValueType.STRING, DataHelpers.generateRandomString(10));
			SqlValue dato6 = new SqlValue(ValueType.STRING, DataHelpers.getStringData());
			SqlValue dato7 = new SqlValue(ValueType.STRING, (DataHelpers.getNubmer(1, 100) > 50)?"S":"N");
			test.add(sql.getDml("INSERIMENTO_PERSONALE_MARITTIMO", dato1,dato2,dato3,dato4,dato5,dato6,dato7).getSql());
		}



		//TECNICO
		for(int i = 0; i < 10; i++){
			String id = DataHelpers.generateCode();
			tecnico.add(id);
			SqlValue dato1 = new SqlValue(ValueType.STRING, id);
			SqlValue dato2 = new SqlValue(ValueType.STRING, DataHelpers.nomi.get(10-i));
			SqlValue dato3 = new SqlValue(ValueType.STRING, DataHelpers.cognomi.get(10-i));
			SqlValue dato4 = new SqlValue(ValueType.STRING, DataHelpers.generateRandomString(10));
			SqlValue dato5 = new SqlValue(ValueType.STRING, DataHelpers.generateRandomString(10));
			SqlValue dato6 = new SqlValue(ValueType.DOUBLE, DataHelpers.getNubmer(10000,15000));

			test.add(sql.getDml("INSERIMENTO_TECNICO", dato1,dato2,dato3,dato4,dato5,dato6).getSql());
			for(int j = 0; j < 2; j++){
				SqlValue dato7 = new SqlValue(ValueType.STRING, id);
				SqlValue dato8 = new SqlValue(ValueType.STRING, modelli.get(i));
				test.add(sql.getDml("INSERIMENTO_SPECIALIZZAZIONE", dato7,dato8).getSql());
			}

		}
		//TEST
		for(int i = 0; i < 10; i++){
			String id = DataHelpers.generateRandomString(10);
			testEseguiti.add(id);
			SqlValue dato1 = new SqlValue(ValueType.STRING, id);
			SqlValue dato2 = new SqlValue(ValueType.INT, "20");
			SqlValue dato3 = new SqlValue(ValueType.STRING, DataHelpers.generateRandomString(10));
			test.add(sql.getDml("INSERIMENTO_TEST", dato1,dato2,dato3).getSql());
		}


		//TEST ESEGUITI
		for(int i = 0; i < 10; i++){
			SqlValue dato1 = new SqlValue(ValueType.STRING, testEseguiti.get(i));
			SqlValue dato2 = new SqlValue(ValueType.STRING, imbarcazioni.get(i));
			SqlValue dato3 = new SqlValue(ValueType.STRING, tecnico.get(i));
			SqlValue dato4 = new SqlValue(ValueType.STRING, DataHelpers.getStringData());
			SqlValue dato5 = new SqlValue(ValueType.STRING, "0 " + DataHelpers.getStringTime() + ":00");
			SqlValue dato6 = new SqlValue(ValueType.INT, "2");

			test.add(sql.getDml("INSERIMENTO_TEST_ESEGUITO", dato1,dato2,dato3,dato4,dato5,dato6).getSql());
		}
		
		System.out.println("END");
		for(int i = 0; i < test.size();i++){
			System.out.println(test.get(i)+";");
		}	
		System.out.println("END");
	}
}
