package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Modello;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoModello extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Modello.class);

		String codice = values.get(Modello.CODICE);
		String pescaggio = values.get(Modello.PESCAGGIO);
		String lunghezza = values.get(Modello.LUNGHEZZA);
		String stazza = values.get(Modello.STAZZA);

		String msg = "";
		String status ="0";
		if(Helpers.areNotStringsEmpty(codice,pescaggio,lunghezza,pescaggio)){
			codice = Helpers.trunc(codice,10);
			SqlValue dato1 = new SqlValue(ValueType.STRING, codice);
			SqlValue dato2 = new SqlValue(ValueType.INT, stazza);
			SqlValue dato3 = new SqlValue(ValueType.INT, lunghezza);
			SqlValue dato4 = new SqlValue(ValueType.INT, pescaggio);
			try{
				
			crud.insert(sql.getDml("INSERIMENTO_MODELLO", dato1,dato2,dato3,dato4));
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