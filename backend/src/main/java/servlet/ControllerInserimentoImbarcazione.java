package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Imbarcazione;
import dataViews.Modello;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoImbarcazione extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Imbarcazione.class);

		String d1 = values.get(Imbarcazione.MATRICOLA);
		String d2 = values.get(Imbarcazione.MODELLO);
		String d3 = values.get(Imbarcazione.SOCIO);

		String msg = "";
		String status ="0";
		if(Helpers.areNotStringsEmpty(d1,d2,d3)){
			d1 = Helpers.trunc(d1,10);
			SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
			SqlValue dato2 = new SqlValue(ValueType.STRING, d2);
			SqlValue dato3 = new SqlValue(ValueType.STRING, d3);
			try{
				crud.insert(sql.getDml("INSERIMENTO_IMBARCAZIONE", dato1,dato2,dato3));
				crud.endTransaction();
			} catch(DbmsException e){
				status = "1";
				msg = getLabel("NOT_OK_INSERT");

			}
		} else{			
			status = "1";
			msg = getLabel("DATO_MANCANTE");
		}

		setJsonResponse(response,status,msg);
	}	

	public String getServletName(){
		return "ControllerInsermentoModello";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}