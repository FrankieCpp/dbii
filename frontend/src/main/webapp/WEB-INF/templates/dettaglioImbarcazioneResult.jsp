<%@ page import="java.util.List"%>
<%@ page language="java" import="model.ImbarcazioneArchivio"%>
<%@ page language="java" import="model.Modello"%>
<%@ page language="java" import="model.TestEseguito"%>
<%@ page language="java" import="model.PersonaleMarittimo"%>
<%
	List<ImbarcazioneArchivio> imbarcazioneArchivio = (List<ImbarcazioneArchivio>) request
			.getAttribute("imbarcazioneArchivio");
	List<Modello> modelloimbarcazione = (List<Modello>) request.getAttribute("modelloimbarcazione");
	List<PersonaleMarittimo> capitani = (List<PersonaleMarittimo>) request.getAttribute("capitani");
	List<TestEseguito> testEseguito = (List<TestEseguito>) request.getAttribute("testEseguito");
%>
<div>
	<h3>Imbarcazione</h3>
</div>
<%
	if (imbarcazioneArchivio != null && imbarcazioneArchivio.size() > 0) {
%>
<div>
	<div class="row">
		<div class="col-md-3">Matricola:</div>
		<div class="col-md-9"><%=imbarcazioneArchivio.get(0).getMatricola()%></div>
	</div>
</div>
<%
	}
%>
<%
	if (modelloimbarcazione != null && modelloimbarcazione.size() > 0) {
%>
<div>
	<div>
		<h3>Modello</h3>
	</div>
	<div class="row">
		<div class="col-md-3">Codice:</div>
		<div class="col-md-9"><%=imbarcazioneArchivio.get(0).getModello()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Lunghezza:</div>
		<div class="col-md-9"><%=modelloimbarcazione.get(0).getLunghezza()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Stazza:</div>
		<div class="col-md-9"><%=modelloimbarcazione.get(0).getStazza()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Pescaggio:</div>
		<div class="col-md-9"><%=modelloimbarcazione.get(0).getPescaggio()%></div>
	</div>
</div>
<%
	}
%>

<%
	if (capitani != null && capitani.size() > 0) {
%>
<div>
	<div>
		<h3>capitani</h3>
	</div>
	<div class="row">
		<div class="col-md-3">Nome:</div>
		<div class="col-md-9"><%=capitani.get(0).getNome()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Cognome:</div>
		<div class="col-md-9"><%=capitani.get(0).getCognome()%></div>
	</div>
</div>
<%
	}
%>
<%
	if (testEseguito != null && testEseguito.size() > 0) {
		for(int i = 0; i < testEseguito.size(); i++){
%>
<div>
	<div>
		<h3>test Eseguito</h3>
	</div>
	<div class="row">
		<div class="col-md-3">Data di esecuzione:</div>
		<div class="col-md-9"><%=testEseguito.get(i).getDatadiesecuzione()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Nome:</div>
		<div class="col-md-9"><%=testEseguito.get(i).getNometest()%></div>
	</div>
	<div class="row">
		<div class="col-md-3">Punteggio:</div>
		<div class="col-md-9"><%=testEseguito.get(i).getPunteggio()%></div>
	</div>
</div>
<%
		}
	}
%>
