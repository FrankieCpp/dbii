<%@ page language="java" import="dataViews.PersonaleMarittimo"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script type="text/javascript" src='js/dataValidation.js'></script>
<script type="text/javascript" src='js/inserimentopersonalemarittimo.js'></script>
<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Inserimento PersonaleMarittimo</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-personalemar-form" class="needs-validation"
					novalidate="" method="post"
					action="/frontend/inspersonalemarrisultato.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">PersonaleMarittimo
							inserito</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.CODICE_FISCALE%></label>
							<div class="input-group">
								<input class="form-control" id="<%=PersonaleMarittimo.CODICE_FISCALE%>"
									name="<%=PersonaleMarittimo.CODICE_FISCALE%>"
									placeholder="<%=PersonaleMarittimo.CODICE_FISCALE%>" required=""
									type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.CODICE_FISCALE%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.NOME%></label>
							<div class="input-group">
								<input class="form-control" id="<%=PersonaleMarittimo.NOME%>"
									name="<%=PersonaleMarittimo.NOME%>" placeholder="<%=PersonaleMarittimo.NOME%>"
									required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.NOME%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.COGNOME%></label>
							<div class="input-group">
								<input class="form-control" id="<%=PersonaleMarittimo.COGNOME%>"
									name="<%=PersonaleMarittimo.COGNOME%>" placeholder="<%=PersonaleMarittimo.COGNOME%>"
									required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.COGNOME%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.INDIRIZZO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=PersonaleMarittimo.INDIRIZZO%>"
									name="<%=PersonaleMarittimo.INDIRIZZO%>"
									placeholder="<%=PersonaleMarittimo.INDIRIZZO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.INDIRIZZO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.TELEFONO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=PersonaleMarittimo.TELEFONO%>"
									name="<%=PersonaleMarittimo.TELEFONO%>"
									placeholder="<%=PersonaleMarittimo.TELEFONO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.TELEFONO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=PersonaleMarittimo.DATAULTIMAVISITA%></label>
							<div class="input-group">
								<input class="form-control"
									id="<%=PersonaleMarittimo.DATAULTIMAVISITA%>"
									name="<%=PersonaleMarittimo.DATAULTIMAVISITA%>"
									placeholder="<%=PersonaleMarittimo.DATAULTIMAVISITA%>" type="date"
								min="1000-01-01" max="3000-12-31" class="form-control"
								required="" />
								<div class="invalid-feedback" style="width: 100%;"><%=PersonaleMarittimo.DATAULTIMAVISITA%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"></label>
							<label for="username">
								<input class="form-control" id="<%=PersonaleMarittimo.E_CAPITANO%>"
									name="<%=PersonaleMarittimo.E_CAPITANO%>" type="checkbox" />e' capitano		
							</label>
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