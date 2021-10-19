package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.PersonaleMarittimo;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dbii.database_framework.utils.DbmsException;
import utils.Helpers;
import utils.ResponseType;

public class ControllerInserimentoPersonaleMarittimo extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, PersonaleMarittimo.class);

		String d1 = values.get(PersonaleMarittimo.CODICE_FISCALE);
		String d2 = values.get(PersonaleMarittimo.COGNOME);
		String d3 = values.get(PersonaleMarittimo.NOME);
		String d4 = values.get(PersonaleMarittimo.INDIRIZZO);
		String d5 = values.get(PersonaleMarittimo.TELEFONO);
		String d6 = values.get(PersonaleMarittimo.DATAULTIMAVISITA);
		String d7 = values.get(PersonaleMarittimo.E_CAPITANO);
		
		d7 = (d7 != null || "S".equals(d7))?"S":"N";
		String status = "0";
		String msg = "";
		try{
			if(Helpers.areNotStringsEmpty(d1,d2,d3,d4,d5,d6,d7)){
				d1 = Helpers.trunc(d1, 16);
				SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
				SqlValue dato2 = new SqlValue(ValueType.STRING, d2);
				SqlValue dato3 = new SqlValue(ValueType.STRING, d3);
				SqlValue dato4 = new SqlValue(ValueType.STRING, d4);
				SqlValue dato5 = new SqlValue(ValueType.STRING, d5);
				SqlValue dato6 = new SqlValue(ValueType.STRING, d6);
				SqlValue dato7 = new SqlValue(ValueType.STRING, d7);

				try{

					crud.insert(sql.getDml("INSERIMENTO_PERSONALE_MARITTIMO", dato1,dato2,dato3,dato4,dato5,dato6,dato7));
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