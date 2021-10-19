package servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Imbarcazione;
import dto.JspAttribute;
import model.ImbarcazioneArchivio;
import utils.Helpers;
import utils.ResponseType;

public class ControllerArchivioImbarcazioni extends ControllerBase {
	private static final long serialVersionUID = 1L;
	private boolean where = false;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		where = false;
		Map<String,String> values = getDataFromView(request, Imbarcazione.class);
		StringBuilder query = new StringBuilder(sql.getQuery(ImbarcazioneArchivio.class, "GET_ARCHIVIO_IMBARCAZIONI").getSql());
		String data = values.get(Imbarcazione.MATRICOLA);
		if(!Helpers.isStringEmpty(data)){
			append(query);
			query.append(" MATRICOLA like '" + data+"%'");			
		}
		List<ImbarcazioneArchivio> list = crud.read(sql.getDirectQuery(ImbarcazioneArchivio.class, query.toString()));
		crud.endTransaction();

		JspAttribute<List<ImbarcazioneArchivio>> attr = new JspAttribute<List<ImbarcazioneArchivio>>("result", list);
		directTo(request,response, "WEB-INF/templates/archivioImbarcazioniResult.jsp", attr);
	}	

	public String getServletName(){
		return "ControllerTestArchive";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSP;
	}
	
	private void append(StringBuilder query){
		if(!this.where){
			query.append(" WHERE ");
			this.where = true;
		} else
			query.append(" AND ");

	}
}