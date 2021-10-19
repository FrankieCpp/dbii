<%@ page language="java" import="dataViews.Socio"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script src="js/dataValidation.js"></script>
<script src="js/archiviosoci.js"></script>
<title>Matr: 640690 - Francesco Coppi</title>
</head>
<body>
	<form id="test-archive-form" class="needs-validation" novalidate=""
		method="post" action="/frontend/archiviosocirisultato.html">
		<div class="jumbotron mt-3">
			<h3>Archivio Soci</h3>
			<div class="col-md-12">
				<button type="button" class="btn btn-mini btn-sm btn-primary button-right" id="filter-button">Cerca</button>
			</div>
		</div>
	</form>
	<div id="tableResult" class="hide">VUOTO</div>
</body>
</html>