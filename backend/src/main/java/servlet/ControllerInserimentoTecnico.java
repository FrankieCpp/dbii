package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Tecnico;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoTecnico extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Tecnico.class);

		String[] models = request.getParameterValues(Tecnico.MODELLI);
		String d1 = values.get(Tecnico.CODICE_FISCALE);
		String d2 = values.get(Tecnico.COGNOME);
		String d3 = values.get(Tecnico.NOME);
		String d4 = values.get(Tecnico.INDIRIZZO);
		String d5 = values.get(Tecnico.TELEFONO);
		String d6 = values.get(Tecnico.SALARIO);
		write(Tecnico.MODELLI+ ": " + models);

		String status = "0";
		String msg = "";
		try{

			Double.parseDouble(d6);
			if(Helpers.areNotStringsEmpty(d1,d2,d3,d4,d5,d6) && models.length > 0){
				d1 = Helpers.trunc(d1, 16);
				SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
				SqlValue dato2 = new SqlValue(ValueType.STRING, d2);
				SqlValue dato3 = new SqlValue(ValueType.STRING, d3);
				SqlValue dato4 = new SqlValue(ValueType.STRING, d4);
				SqlValue dato5 = new SqlValue(ValueType.STRING, d5);
				SqlValue dato6 = new SqlValue(ValueType.DOUBLE, d6);

				try{

					crud.insert(sql.getDml("INSERIMENTO_TECNICO", dato1,dato2,dato3,dato4,dato5,dato6));
					for(int i = 0; i < models.length; i++){
						SqlValue dato7 = new SqlValue(ValueType.STRING, d1);
						SqlValue dato8 = new SqlValue(ValueType.STRING, models[i]);
						crud.insert(sql.getDml("INSERIMENTO_SPECIALIZZAZIONE", dato7,dato8));

					}
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
		return "ControllerInsermentoTecnico";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSON;
	}
}