package servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.TestArchive;
import dto.JspAttribute;
import model.TestInsertions;
import utils.Helpers;
import utils.ResponseType;

public class ControllerTestArchive extends ControllerBase {
	private static final long serialVersionUID = 1L;
	private boolean where = false;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		where = false;
		Map<String,String> values = getDataFromView(request, TestArchive.class);
		StringBuilder query = new StringBuilder("SELECT * FROM TESTINSERTIONS ");
		String data = values.get(TestArchive.ID);
		if(!Helpers.isStringEmpty(data)){
			append(query);
			query.append(" IDNUMBER =" + data);			
		}
		data = values.get(TestArchive.END_DATE);
		if(!Helpers.isStringEmpty(data)){
			append(query);
			query.append(" DATACREAZIONE <= TO_DATE('" + data + "','YYYY-MM-DD')");			
		}
		data = values.get(TestArchive.START_DATE);
		if(!Helpers.isStringEmpty(data)){
			append(query);
			query.append(" DATACREAZIONE >= TO_DATE('" + data + "','YYYY-MM-DD')");			
		}
		List<TestInsertions> list = crud.read(sql.getDirectQuery(TestInsertions.class, query.toString()));
		crud.endTransaction();

		JspAttribute<List<TestInsertions>> attr = new JspAttribute<List<TestInsertions>>("result", list);
		directTo(request,response, "WEB-INF/templates/testArchiveResult.jsp", attr);
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