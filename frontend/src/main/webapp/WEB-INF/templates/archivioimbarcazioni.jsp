<%@ page language="java" import="dataViews.Imbarcazione"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script src="js/dataValidation.js"></script>
<script src="js/archivioimbarcazioni.js"></script>
<title>Matr: 640690 - Francesco Coppi</title>
</head>
<body>
	<form id="test-archive-form" class="needs-validation" novalidate=""
		method="post" action="/frontend/archivioimbarcazionirisultato.html">
		<div class="jumbotron mt-3">
			<h3>Archivio</h3>
			<div class="row">
				<div class="col-md-4 mb-3">
					<label for="firstName"><%=Imbarcazione.MATRICOLA%></label> 
					<input id="firstName" name="<%=Imbarcazione.MATRICOLA%>" placeholder="" value="" type="text">
				</div>
			</div>
			<div class="col-md-12">
				<button type="button" class="btn btn-mini btn-sm btn-primary button-right" id="filter-button">Cerca</button>
			</div>

		</div>
	</form>
	<div id="tableResult" class="hide">VUOTO</div>
</body>
</html>