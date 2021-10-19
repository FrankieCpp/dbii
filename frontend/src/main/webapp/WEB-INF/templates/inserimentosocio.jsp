<%@ page language="java" import="dataViews.Socio"%>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page='mainHeader.jsp'></jsp:include>
	<script type="text/javascript" src='js/dataValidation.js'></script>
	<script type="text/javascript" src='js/inserimentosocio.js'></script>
	<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Inserimento socio</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-socio-form" class="needs-validation" novalidate="" method="post" action="/frontend/inseriscisocio.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Socio inserito</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username">Codice fiscale</label>
							<div class="input-group">
								<input class="form-control" id="<%=Socio.CODICE_FISCALE%>" name="<%=Socio.CODICE_FISCALE%>"
									placeholder="<%=Socio.CODICE_FISCALE%>" required="" type="text">
								<div class="invalid-feedback" style="width: 100%;">Codice fiscale è obbligatorio</div>
							</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right" id="sendtest" type="submit">Inserisci un nuovo Socio</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>