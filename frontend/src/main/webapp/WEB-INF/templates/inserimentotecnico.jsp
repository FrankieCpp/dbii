<%@ page language="java" import="dataViews.Tecnico"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script type="text/javascript" src='js/dataValidation.js'></script>
<script type="text/javascript" src='js/inserimentotecnico.js'></script>
<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Inserimento Tecnico</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-tecnico-form" class="needs-validation"
					novalidate="" method="post"
					action="/frontend/inserimentotecnicorisultato.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Tecnico
							inserito</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.CODICE_FISCALE%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.CODICE_FISCALE%>"
									name="<%=Tecnico.CODICE_FISCALE%>"
									placeholder="<%=Tecnico.CODICE_FISCALE%>" required=""
									type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.CODICE_FISCALE%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.NOME%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.NOME%>"
									name="<%=Tecnico.NOME%>" placeholder="<%=Tecnico.NOME%>"
									required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.NOME%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.COGNOME%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.COGNOME%>"
									name="<%=Tecnico.COGNOME%>" placeholder="<%=Tecnico.COGNOME%>"
									required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.COGNOME%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.INDIRIZZO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.INDIRIZZO%>"
									name="<%=Tecnico.INDIRIZZO%>"
									placeholder="<%=Tecnico.INDIRIZZO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.INDIRIZZO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.TELEFONO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.TELEFONO%>"
									name="<%=Tecnico.TELEFONO%>"
									placeholder="<%=Tecnico.TELEFONO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.TELEFONO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.SALARIO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Tecnico.SALARIO%>"
									name="<%=Tecnico.SALARIO%>"
									placeholder="<%=Tecnico.SALARIO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.SALARIO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Tecnico.MODELLI%></label>
							<div class="input-group">
								<select
									class="mdb-select colorful-select dropdown-primary form-control"
									multiple searchable="Search here.." id="<%=Tecnico.MODELLI%>"
									name="<%=Tecnico.MODELLI%>" placeholder="<%=Tecnico.MODELLI%>"
									required="">
								</select>
								<div class="invalid-feedback" style="width: 100%;"><%=Tecnico.MODELLI%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right"
								id="sendtest" type="submit">Inserisci tecnico</button>
						</div>
					</div>
				</form>
				<div class="hide">
					<form id="get-soci-form" method="post"
						action="/frontend/getsoci.html"></form>
					<form id="get-modelli-form" method="post"
						action="/frontend/getmodelli.html"></form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>