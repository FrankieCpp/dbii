<%@ page language="java" import="dataViews.Test"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script type="text/javascript" src='js/dataValidation.js'></script>
<script type="text/javascript" src='js/inserimentotest.js'></script>
<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container" id="maindiv">
		<div class="py-5 text-center">
			<h2>Inserimento Test</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-test-form" class="needs-validation"
					novalidate="" method="post"
					action="/frontend/inserimentotestrisultato.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Test
							inserito</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=Test.CODICE%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Test.CODICE%>"
									name="<%=Test.CODICE%>"
									placeholder="<%=Test.CODICE%>" required=""
									type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Test.CODICE%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Test.NOME%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Test.NOME%>"
									name="<%=Test.NOME%>" placeholder="<%=Test.NOME%>"
									required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Test.NOME%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=Test.PUNTEGGIO%></label>
							<div class="input-group">
								<input class="form-control" id="<%=Test.PUNTEGGIO%>"
									name="<%=Test.PUNTEGGIO%>"
									placeholder="<%=Test.PUNTEGGIO%>" required="" type="text" />
								<div class="invalid-feedback" style="width: 100%;"><%=Test.PUNTEGGIO%>
									è obbligatorio
								</div>
							</div>
						</div>
					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right"
								id="sendtest" type="submit">Inserisci test</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>