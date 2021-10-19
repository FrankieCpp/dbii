package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.JsonTest;
import utils.ResponseType;

public class ControllerGetTest extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<model.Test> list = crud.read(sql.getQuery(model.Test.class, "GET_TEST"));
		JsonTest tests = new JsonTest();
		tests.setTest(list);
		setJsonResponse(response, tests);
	}	

	public String getServletName(){
		return "ControllerGetTest";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}