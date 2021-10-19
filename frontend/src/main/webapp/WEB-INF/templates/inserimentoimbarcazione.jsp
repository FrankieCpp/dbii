<%@ page language="java" import="dataViews.Imbarcazione"%>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page='mainHeader.jsp'></jsp:include>
	<script type="text/javascript" src='js/dataValidation.js'></script>
	<script type="text/javascript" src='js/inserimentoimbarcazione.js'></script>
	<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container hide" id="maindiv">
		<div class="py-5 text-center">
			<h2>Inserimento Imbarcazione</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-imbarcazione-form" class="needs-validation" novalidate="" method="post" action="/frontend/insimbarcazionerisultato.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Imbarcazione inserita</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=Imbarcazione.MATRICOLA%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Imbarcazione.MATRICOLA%>" name="<%=Imbarcazione.MATRICOLA%>"
									placeholder="<%=Imbarcazione.MATRICOLA%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Imbarcazione.MATRICOLA%> è obbligatorio</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Imbarcazione.MODELLO%></label>
							<div class="input-group">
								<select class="form-control" id="<%=Imbarcazione.MODELLO%>" name="<%=Imbarcazione.MODELLO%>"
									placeholder="<%=Imbarcazione.MODELLO%>" required="">
									</select>
								<div class="invalid-feedback" style="width: 100%;"><%=Imbarcazione.MODELLO%> è obbligatorio</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Imbarcazione.SOCIO%></label>
							<div class="input-group">
								<select class="form-control" id="<%=Imbarcazione.SOCIO%>" name="<%=Imbarcazione.SOCIO%>"
									placeholder="<%=Imbarcazione.SOCIO%>" required=""></select>
								<div class="invalid-feedback" style="width: 100%;"><%=Imbarcazione.SOCIO%> è obbligatorio</div>
							</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right" id="sendtest" type="submit">Inserisci imbarcazione</button>
						</div>
					</div>	
				</form>
				<div class="hide">
					<form id="get-soci-form" method="post" action="/frontend/getsoci.html">
					</form>
					<form id="get-modelli-form" method="post" action="/frontend/getmodelli.html">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>