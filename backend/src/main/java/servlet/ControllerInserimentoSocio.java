package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Socio;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoSocio extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Socio.class);

		String codiceFiscaleStr = values.get(Socio.CODICE_FISCALE);
		write(getLabel("CODICE_FISCALE") + ": " + codiceFiscaleStr);

		String msg = "";
		String status ="0";
		if(!Helpers.isStringEmpty(codiceFiscaleStr)){
			codiceFiscaleStr = Helpers.trunc(codiceFiscaleStr,16);

			SqlValue nameSql = new SqlValue(ValueType.STRING, codiceFiscaleStr);
			crud.update(sql.getDml("INSERIMENTO_SOCIO", nameSql));
			crud.endTransaction();
		} else{			
			status = "1";
			msg = getLabel("CODICE_FISCALE") + " " + getLabel("MANCANTE");
		}

		setJsonResponse(response,status,msg);

	}	

	public String getServletName(){
		return "ControllerInserimentoSocio";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}