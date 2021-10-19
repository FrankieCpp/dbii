<%@ page language="java" import="dataViews.TestEseguito"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script type="text/javascript" src='js/dataValidation.js'></script>
<script type="text/javascript" src='js/inserimentotesteseguito.js'></script>
<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Inserimento Test Eseguito</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-testeseguito-form" class="needs-validation"
					novalidate="" method="post"
					action="/frontend/instesteseguitorisultato.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">TestEseguito
							inserita</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.TEST%></label>
							<div class="input-group">
								<select class="form-control" id="<%=TestEseguito.TEST%>"
									name="<%=TestEseguito.TEST%>"
									placeholder="<%=TestEseguito.TEST%>" required="">
								</select>
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.TEST%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.IMBARCAZIONE%></label>
							<div class="input-group">
								<select class="form-control" id="<%=TestEseguito.IMBARCAZIONE%>"
									name="<%=TestEseguito.IMBARCAZIONE%>"
									placeholder="<%=TestEseguito.IMBARCAZIONE%>" required=""></select>
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.IMBARCAZIONE%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.TECNICO%></label>
							<div class="input-group">
								<select class="form-control" id="<%=TestEseguito.TECNICO%>"
									name="<%=TestEseguito.TECNICO%>"
									placeholder="<%=TestEseguito.TECNICO%>" required=""></select>
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.TECNICO%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.DATA_ESECUZIONE%></label>
							<div class="input-group">
								<input class="form-control"
									id="<%=TestEseguito.DATA_ESECUZIONE%>"
									name="<%=TestEseguito.DATA_ESECUZIONE%>"
									placeholder="<%=TestEseguito.DATA_ESECUZIONE%>" type="date"
								min="1000-01-01" max="3000-12-31" class="form-control"
								required="" />
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.DATA_ESECUZIONE%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.TEMPO_ESECUZIONE%></label>
							<div class="input-group">
								<input class="form-control"
									id="<%=TestEseguito.TEMPO_ESECUZIONE%>"
									name="<%=TestEseguito.TEMPO_ESECUZIONE%>"
									placeholder="<%=TestEseguito.TEMPO_ESECUZIONE%>" type="time"
								min="00:00:00" max="23:59:59" class="form-control"
								required="" />
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.TEMPO_ESECUZIONE%>
									è obbligatorio
								</div>
							</div>
							<script type="text/javascript">
								$(function() {
									$('#datetimepicker3').datetimepicker({
										pickDate : false
									});
								});
							</script>
						</div>
						<div class="col-md-4 mb-4">
							<label for="username"><%=TestEseguito.PUNTEGGIO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=TestEseguito.PUNTEGGIO%>"
									name="<%=TestEseguito.PUNTEGGIO%>"
									placeholder="<%=TestEseguito.PUNTEGGIO%>" required=""
									type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=TestEseguito.PUNTEGGIO%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>

					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right"
								id="sendtest" type="submit">Inserisci imbarcazione</button>
						</div>
					</div>
				</form>
				<div class="hide">
					<form id="get-imbarcazioni-form" method="post"
						action="/frontend/getimbarcazioni.html"></form>
					<form id="get-test-form" method="post"
						action="/frontend/gettest.html"></form>
					<form id="get-tecnici-form" method="post"
						action="/frontend/gettecnici.html"></form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>