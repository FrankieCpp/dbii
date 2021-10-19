<%@ page language="java" import="dataViews.Modello"%>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page='mainHeader.jsp'></jsp:include>
	<script type="text/javascript" src='js/dataValidation.js'></script>
	<script type="text/javascript" src='js/inserimentomodello.js'></script>
	<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Inserimento Modello</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-modello-form" class="needs-validation" novalidate="" method="post" action="/frontend/inseriscimodello.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Modello inserito</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=Modello.CODICE%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Modello.CODICE%>" name="<%=Modello.CODICE%>"
									placeholder="<%=Modello.CODICE%>" required="" type="text">
								<div class="invalid-feedback" style="width: 100%;"><%=Modello.CODICE%> è obbligatorio</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Modello.STAZZA%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Modello.STAZZA%>" name="<%=Modello.STAZZA%>"
									placeholder="<%=Modello.CODICE%>" required="" type="text">
								<div class="invalid-feedback" style="width: 100%;"><%=Modello.STAZZA%> è obbligatorio</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Modello.LUNGHEZZA%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Modello.CODICE%>" name="<%=Modello.LUNGHEZZA%>"
									placeholder="<%=Modello.LUNGHEZZA%>" required="" type="text">
								<div class="invalid-feedback" style="width: 100%;"><%=Modello.LUNGHEZZA%> è obbligatorio</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Modello.PESCAGGIO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Modello.PESCAGGIO%>" name="<%=Modello.PESCAGGIO%>"
									placeholder="<%=Modello.PESCAGGIO%>" required="" type="text">
								<div class="invalid-feedback" style="width: 100%;"><%=Modello.PESCAGGIO%> è obbligatorio</div>
							</div>
						</div>

					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right" id="sendtest" type="submit">Inserisci un nuovo modello</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>