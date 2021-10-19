package servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.ResponseType;

public class ControllerRouting extends ControllerBase {
	private static final long serialVersionUID = 1L;

	private static Map<String, String> routingMap;

	static{
		routingMap = new HashMap<String, String>();
		routingMap.put("/gotohomepage.html", "WEB-INF/templates/mainPage.jsp");		
		
		routingMap.put("/inserimentosocio.html", "WEB-INF/templates/inserimentosocio.jsp");
		routingMap.put("/inserimentomodello.html", "WEB-INF/templates/inserimentomodello.jsp");
		routingMap.put("/inserimentoimbarcazione.html", "WEB-INF/templates/inserimentoimbarcazione.jsp");
		routingMap.put("/inserimentotecnico.html", "WEB-INF/templates/inserimentotecnico.jsp");
		routingMap.put("/inserimentotest.html", "WEB-INF/templates/inserimentotest.jsp");
		routingMap.put("/inserimentotesteseguito.html", "WEB-INF/templates/inserimentotesteseguito.jsp");	
		routingMap.put("/inserimentopersonalemarittimo.html", "WEB-INF/templates/inserimentopersonalemarittimo.jsp");
		routingMap.put("/inserimentochicomanda.html", "WEB-INF/templates/inserimentochicomanda.jsp");
		
		routingMap.put("/archivioimbarcazioni.html", "WEB-INF/templates/archivioimbarcazioni.jsp");	
		routingMap.put("/archiviosoci.html", "WEB-INF/templates/archiviosoci.jsp");
		routingMap.put("/archiviomodelli.html", "WEB-INF/templates/archiviomodelli.jsp");
		routingMap.put("/archiviotecnici.html", "WEB-INF/templates/archiviotecnici.jsp");
		routingMap.put("/archiviotest.html", "WEB-INF/templates/archiviotest.jsp");
		routingMap.put("/archiviotesteseguiti.html", "WEB-INF/templates/archiviotesteseguiti.jsp");	
		routingMap.put("/archiviopersonalemarittimi.html", "WEB-INF/templates/archiviopersonalemarittimi.jsp");
		routingMap.put("/archiviochicomanda.html", "WEB-INF/templates/archiviochicomanda.jsp");	}

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jspPage = null;
		try{	
			jspPage = routingMap.get(request.getServletPath());
		} 
		catch(Exception e){
			jspPage = "WEB-INF/templates/errorPage.jsp";
		}
		request.getRequestDispatcher(jspPage).forward(request, response);

	}	

	public String getServletName(){
		return "ControllerRouting";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.HTML;
	}
}