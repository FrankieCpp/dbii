package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonCapitani;
import utils.ResponseType;

public class ControllerGetCapitani extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.PersonaleMarittimo> list = crud.read(sql.getQuery(model.PersonaleMarittimo.class, "GET_CAPITANI"));
		JsonCapitani capitani = new JsonCapitani();
		capitani.setCapitani(list);
		setJsonResponse(response, capitani);
	}	

	public String getServletName(){
		return "ControllerGetCapitani";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}