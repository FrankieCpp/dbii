package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dataViews.Socio;
import utils.Helpers;
import utils.ResponseType;

public class ControllerCancellaSoci extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Socio.class);

		String codiceFiscaleStr = values.get(Socio.CODICE_FISCALE);

		String msg = "";
		String status ="0";
		if(!Helpers.isStringEmpty(codiceFiscaleStr)){
			codiceFiscaleStr = Helpers.trunc(codiceFiscaleStr,16);

			SqlValue nameSql = new SqlValue(ValueType.STRING, codiceFiscaleStr);
			crud.delete(sql.getDml("DELETE_SOCIO", nameSql));
			crud.endTransaction();
		} else{			
			status = "1";
			msg = getLabel("CODICE_FISCALE") + " " + getLabel("MANCANTE");
		}

		setJsonResponse(response,status,msg);

	}	

	public String getServletName(){
		return "ControllerTestArchive";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSP;
	}
}