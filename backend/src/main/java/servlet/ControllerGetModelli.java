package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonModelli;
import utils.ResponseType;

public class ControllerGetModelli extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.Modello> list = crud.read(sql.getQuery(model.Modello.class, "GET_MODELLI"));
		JsonModelli soci = new JsonModelli();
		soci.setModelli(list);
		setJsonResponse(response, soci);
	}	

	public String getServletName(){
		return "ControllerGetModelli";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}