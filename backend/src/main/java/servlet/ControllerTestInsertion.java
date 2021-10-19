package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.TestInsertion;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import utils.ResponseType;

public class ControllerTestInsertion extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, TestInsertion.class);

		Integer number = Integer.parseInt(values.get(TestInsertion.NUMBER));
		String nameStr =values.get(TestInsertion.FIRST_NAME);
		String data = values.get(TestInsertion.DATETIMEPICKER);

		SqlValue nameSql = new SqlValue(ValueType.STRING, nameStr);
		SqlValue numberSql = new SqlValue(ValueType.INT, number);
		SqlValue dateSql = new SqlValue(ValueType.DATE, data);

		crud.update(sql.getDml("INSERT_TEST_INSERTION", nameSql, numberSql, dateSql));
		crud.endTransaction();

		setJsonResponse(response,"0","");
	}	

	public String getServletName(){
		return "ControllerTestInsertion";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}