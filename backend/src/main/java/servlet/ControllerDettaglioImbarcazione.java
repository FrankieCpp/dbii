package servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataViews.Imbarcazione;
import dbii.database_framework.crud.enums.ValueType;
import dbii.database_framework.crud.sql.SqlValue;
import dto.JspAttribute;
import model.ComandabileDa;
import model.ImbarcazioneArchivio;
import model.Modello;
import model.PersonaleMarittimo;
import model.TestEseguito;
import utils.ResponseType;

public class ControllerDettaglioImbarcazione extends ControllerBase {
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> values = getDataFromView(request, Imbarcazione.class);

		String d1 = values.get(Imbarcazione.MATRICOLA);
		SqlValue dato1 = new SqlValue(ValueType.STRING, d1);
		List<Modello> modelloimbarcazione = null;
		List<ComandabileDa> comandabileda = null;
		List<PersonaleMarittimo> capitani = null;
		List<TestEseguito> testEseguito = null;
		List<ImbarcazioneArchivio> imbarcazioneArchivio = crud.read(sql.getQuery(ImbarcazioneArchivio.class,"GET_IMBARCAZIONE",dato1));

		if(imbarcazioneArchivio != null && !imbarcazioneArchivio.isEmpty()){
			dato1 = new SqlValue(ValueType.STRING, imbarcazioneArchivio .get(0).getModello());
			modelloimbarcazione = crud.read(sql.getQuery(Modello.class,"GET_MODELLO",dato1));
		}
		if(imbarcazioneArchivio != null && !imbarcazioneArchivio.isEmpty()){
			dato1 = new SqlValue(ValueType.STRING, imbarcazioneArchivio .get(0).getModello());
			comandabileda = crud.read(sql.getQuery(ComandabileDa.class,"GET_COMANDANTI_DI",dato1));
			
			if(comandabileda != null && !comandabileda.isEmpty()){
				dato1 = new SqlValue(ValueType.STRING, comandabileda.get(0).getCapitano());
				capitani = crud.read(sql.getQuery(PersonaleMarittimo.class,"GET_PERSONALE_MARITTIMO",dato1));
			}
			
			dato1 = new SqlValue(ValueType.STRING, imbarcazioneArchivio.get(0).getMatricola());
			testEseguito = crud.read(sql.getQuery(TestEseguito.class,"GET_TEST_ESEGUITI_SU_IMBARCAZIONE",dato1));
			
		}
		JspAttribute<List<ImbarcazioneArchivio>> attr = new JspAttribute<List<ImbarcazioneArchivio>>("imbarcazioneArchivio", imbarcazioneArchivio );
		JspAttribute<List<Modello>> attr2 = new JspAttribute<List<Modello>>("modelloimbarcazione", modelloimbarcazione );
		JspAttribute<List<PersonaleMarittimo>> attr3 = new JspAttribute<List<PersonaleMarittimo>>("capitani", capitani );
		JspAttribute<List<TestEseguito>> attr4 = new JspAttribute<List<TestEseguito>>("testEseguito", testEseguito);
		directTo(request,response, "WEB-INF/templates/dettaglioImbarcazioneResult.jsp", attr,attr2, attr3, attr4);
	}	

	public String getServletName(){
		return "ControllerDettaglioImbarcazione";
	}

	@Override
	ResponseType getResponseType() {
		return ResponseType.JSP;
	}
}