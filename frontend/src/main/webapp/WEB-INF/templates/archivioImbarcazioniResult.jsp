<%@ page import="java.util.List"%>
<%@ page language="java" import="model.ImbarcazioneArchivio"%>
<% List<ImbarcazioneArchivio> res = (List<ImbarcazioneArchivio>)request.getAttribute("result"); %>

<div id="dettaglioImbarcazione" class="hide bordered"></div>
<table class="table table-hover table-sm">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Matricola</th>
			<th scope="col">Socio</th>
			<th scope="col">Modello</th>
			<th scope="col">azioni</th>
		</tr>
	</thead>
	<tbody>
		<% for(int i = 0; i < res.size(); i++) {
			out.println("<tr id=\"riga"+i+"\" position=\""+(i+1)+"\">");
			out.println("<td>"+(i+1)+"</td>");
			out.println("<td>"+res.get(i).getMatricola()+"</td>");
			out.println("<td>"+res.get(i).getSocio()+"</td>");
			out.println("<td>"+res.get(i).getModello()+"</td>");
			out.println("<td><a href=\"javascript:void(0);\" onclick=\"dettaglioImbarcazione('"+res.get(i).getMatricola()+"',"+i+")\">D</a></td>");			
			out.println("</tr>"); 
		} %>
	</tbody>
</table>

<div class="hide">
	<form id="dettaglio-imbarcazioni-form" method="post" action="/frontend/dettaglioimbarazioni.html">
		<input type="hidden" id="<%= dataViews.Imbarcazione.MATRICOLA%>" name="<%=dataViews.Imbarcazione.MATRICOLA%>" />
	</form>
</div>