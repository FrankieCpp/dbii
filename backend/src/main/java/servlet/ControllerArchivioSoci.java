package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JspAttribute;
import model.Socio;
import utils.ResponseType;

public class ControllerArchivioSoci extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuilder query = new StringBuilder(sql.getQuery(Socio.class, "GET_SOCI").getSql());
		List<Socio> list = crud.read(sql.getDirectQuery(Socio.class, query.toString()));
		crud.endTransaction();

		JspAttribute<List<Socio>> attr = new JspAttribute<List<Socio>>("result", list);
		directTo(request,response, "WEB-INF/templates/archivioSociResult.jsp", attr);
	}	

	public String getServletName(){
		return "ControllerTestArchive";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSP;
	}
}