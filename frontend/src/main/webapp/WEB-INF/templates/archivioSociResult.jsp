<%@ page import="java.util.List"%>
<%@ page language="java" import="model.Socio"%>
<% List<Socio> res = (List<Socio>)request.getAttribute("result"); %>
<div class="hide">
<script type="text/javascript">
function cancella(cancellare){
	alert("asfasdfasf");
	debugger;
	$("#codiceFiscale").val(cancellare.trim());
	$.post($("#delete-soci-form").attr("action"), $("#delete-soci-form").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			$.post($("#test-archive-form").attr("action"),$("#test-archive-form").serialize(), function(data){
	        	$("#tableResult").html(data).removeClass("hide");	
	        });
		}
	});

}
</script>
</div>
<table class="table table-hover table-sm">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Codice fiscale</th>
			<th scope="col">azioni</th>
		</tr>
	</thead>
	<tbody>
		<% for(int i = 0; i < res.size(); i++) {
			out.println("<tr>");
			out.println("<td>"+(i+1)+"</td>");
			out.println("<td>"+res.get(i).getCodiceFiscale()+"</td>");
			out.println("<td><a href=\"javascript:void(0);\" onclick=\"cancella('"+res.get(i).getCodiceFiscale()+"');\">cancella</a></td>");
			out.println("</tr>"); 
		} %>
	</tbody>
</table>

<div class="hide">
	<form id="delete-soci-form" method="post" action="/frontend/deletesoci.html">
		<input type="hidden" id="<%= dataViews.Socio.CODICE_FISCALE%>" name="<%=dataViews.Socio.CODICE_FISCALE%>" />
	</form>
</div>