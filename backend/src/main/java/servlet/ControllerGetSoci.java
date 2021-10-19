package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonSoci;
import utils.ResponseType;

public class ControllerGetSoci extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.Socio> list = crud.read(sql.getQuery(model.Socio.class, "GET_SOCI"));
		JsonSoci soci = new JsonSoci();
		soci.setSoci(list);
		setJsonResponse(response, soci);
	}	

	public String getServletName(){
		return "ControllerGetSoci";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}