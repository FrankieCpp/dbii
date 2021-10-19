package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonModelli;
import dto.JsonTecnici;
import utils.ResponseType;

public class ControllerGetTecnici extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.Tecnico> list = crud.read(sql.getQuery(model.Tecnico.class, "GET_TECNICI"));
		JsonTecnici tecnici = new JsonTecnici();
		tecnici.setTecnici(list);
		setJsonResponse(response, tecnici);
	}	

	public String getServletName(){
		return "ControllerGetTecnici";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}