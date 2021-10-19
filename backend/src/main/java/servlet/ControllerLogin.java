package servlet;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.Crypter;
import dbii.database_framework.utils.DbmsException;
import model.Users;
import utils.Helpers;
import utils.ResponseType;

public class ControllerLogin extends ControllerBase {

	private static final long serialVersionUID = 1L;
	private final static String PWD ="pwd";
	private final static String USERNAME ="username";
	private String pwd;
	/** 
	 * parameters:
	 * 	username
	 *  pwd
	 * @throws Exception 
	 */
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean found = false;
		try {
			String pwdStr = request.getParameter(PWD);
			String usernameStr = request.getParameter(USERNAME);

			write(getLabel("PWD") + ": " + usernameStr);
			write(getLabel("USR") + ": " + pwdStr);

			if(Helpers.areNotStringsEmpty(pwdStr, usernameStr)){

				this.pwd = Crypter.encode(pwdStr);

				SqlValue username = new SqlValue(ValueType.STRING, usernameStr);
				List<Users> list = crud.read(sql.getQuery(Users.class,"GET_USER", username));

				found = list.parallelStream().anyMatch(e -> {
					return e.getPassword().equals(this.pwd);
				});

				if(found) {
					SqlValue random = new SqlValue(ValueType.STRING, Helpers.getRandomString(64));
					crud.update(sql.getDml("UPDATE_SESSIONKEY", random, username));
					crud.endTransaction();

					Cookie cookie = new Cookie(SESSION_KEY, (String) random.getValue());
					cookie.setMaxAge(24*60*60);
					response.addCookie(cookie); 

					cookie = new Cookie(USERID, (String) usernameStr);
					cookie.setMaxAge(24*60*60);
					response.addCookie(cookie); 

					write(getLabel("SESSION_KEY_NAME")+ " " +random.getValue());
				}
			}
		} catch (DbmsException e) {
			found = null;
		}

		String label = "";
		if(found == null){
			label = getLabel("GENERIC_ERROR");
		} else if(!found){
			label = getLabel("INVALID_CREDENTIAL");			
		}

		setJsonResponse(response, Integer.toString(label.length()),label);
	}

	public String getServletName() {
		return "ControllerLogin";
	}

	@Override
	protected boolean setControllerValidation(HttpServletRequest request) {
		return true;
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}
