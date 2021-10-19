<%@ page language="java" import="dataViews.CapModello"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page='mainHeader.jsp'></jsp:include>
<script type="text/javascript" src='js/dataValidation.js'></script>
<script type="text/javascript" src='js/inserimentochicomanda.js'></script>
<title>Matr: 640690 - Compilazione</title>
</head>

<body>
	<div class="container hide" id="maindiv">
		<div class="py-5 text-center">
			<h2>Inserimento Modello</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="inserisci-chicomanda-form" class="needs-validation"
					novalidate="" method="post"
					action="/frontend/inseriscicomandante.html">
					<div id="errorDiv" class="hide">
						<div id="errorDivMsg" class="alert alert-danger"></div>
					</div>
					<div id="successDiv" class="hide">
						<div id="successDivMsg" class="alert alert-primary">Inserici
							relazione</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="username"><%=CapModello.CAPITANO%></label>
							<div class="input-group">
								<select class="form-control" id="<%=CapModello.CAPITANO%>"
									name="<%=CapModello.CAPITANO%>"
									placeholder="<%=CapModello.CAPITANO%>" required="">
								</select>
								<div class="invalid-feedback" style="width: 100%;"><%=CapModello.CAPITANO%>
									è obbligatorio
								</div>
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="username"><%=CapModello.MODELLO%></label>
							<div class="input-group">
								<select class="form-control" id="<%=CapModello.MODELLO%>"
									name="<%=CapModello.MODELLO%>"
									placeholder="<%=CapModello.MODELLO%>" required=""></select>
								<div class="invalid-feedback" style="width: 100%;"><%=CapModello.MODELLO%>
									è obbligatorio
								</div>
							</div>
						</div>

					</div>
					<hr class="mb-4">
					<div class="row">
						<div class="col-md-4 mb-3 button-right">
							<button class="btn btn-primary btn-mini btn-block button-right"
								id="sendtest" type="submit">Inserisci un nuovo modello</button>
						</div>
					</div>

				</form>
				<div class="hide">
					<form id="get-capitani-form" method="post"
						action="/frontend/getcapitani.html"></form>
					<form id="get-modelli-form" method="post"
						action="/frontend/getmodelli.html"></form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>