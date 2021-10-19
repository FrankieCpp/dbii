package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonImbarcazioni;
import utils.ResponseType;

public class ControllerGetImbarcazioni extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.ImbarcazioneArchivio> list = crud.read(sql.getQuery(model.ImbarcazioneArchivio.class, "GET_ARCHIVIO_IMBARCAZIONI"));
		JsonImbarcazioni imbarcazioni = new JsonImbarcazioni();
		imbarcazioni.setImbarcazioni(list);
		setJsonResponse(response, imbarcazioni);
	}	

	public String getServletName(){
		return this.getClass().getName();
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}