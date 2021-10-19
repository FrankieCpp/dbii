package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.TestEseguito;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoTestEseguito extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, TestEseguito.class);

		String d1 = values.get(TestEseguito.TEST);
		String d2 = values.get(TestEseguito.IMBARCAZIONE);
		String d3 = values.get(TestEseguito.TECNICO);
		String d4 = values.get(TestEseguito.DATA_ESECUZIONE);
		String d5 = values.get(TestEseguito.TEMPO_ESECUZIONE);
		String d6 = values.get(TestEseguito.PUNTEGGIO);

		String status = "0";
		String msg = "";
		try{

			Integer.parseInt(d6);
			if(Helpers.areNotStringsEmpty(d1,d2,d3,d4,d5,d6) ){
				SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
				SqlValue dato2 = new SqlValue(ValueType.STRING, d2);
				SqlValue dato3 = new SqlValue(ValueType.STRING, d3);
				SqlValue dato4 = new SqlValue(ValueType.STRING, d4);
				SqlValue dato5 = new SqlValue(ValueType.STRING, "0 " + d5+ ":00");
				SqlValue dato6 = new SqlValue(ValueType.INT, d6);

				try{

					crud.insert(sql.getDml("INSERIMENTO_TEST_ESEGUITO", dato1,dato2,dato3,dato4,dato5,dato6));
					crud.endTransaction();
				} catch(DbmsException e){
					status = "1";
					msg = getLabel("NOT_OK_INSERT");

				}
			} else{
				status = "1";
				msg = getLabel("DATO_MANCANTE");
			}
		}
		catch(Exception e){
			status = "1";
			msg = getLabel("DATO_ERRATO");
		}


		setJsonResponse(response,status,msg);
	}	

	public String getServletName(){
		return "ControllerInsermentoTestEseguito";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}