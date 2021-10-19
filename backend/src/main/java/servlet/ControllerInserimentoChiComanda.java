package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.CapModello;
import dataViews.Imbarcazione;
import dataViews.Modello;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoChiComanda extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, CapModello.class);

		String d1 = values.get(CapModello.CAPITANO);
		String d2 = values.get(CapModello.MODELLO);

		String msg = "";
		String status ="0";
		if(Helpers.areNotStringsEmpty(d1,d2)){
			SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
			SqlValue dato2 = new SqlValue(ValueType.STRING, d2);
			try{
				crud.insert(sql.getDml("INSERIMENTO_RELAZIONE", dato1,dato2));
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