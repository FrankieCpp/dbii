<!DOCTYPE html>
<html lang='it'>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="css/boostrap4.0.0-beta3.css">
<script type="text/javascript" src="js/jquery3.2.1.js"></script>
<script type="text/javascript" src="js/popper1.12.9.js"></script>
<script type="text/javascript" src="js/bootstrap4.0.0.js"></script>
<script src="js/mainPage.js"></script>
<link rel="stylesheet" type="text/css" href="css/baseCss.css">
<title>Matr: 640690 - Francesco Coppi</title>
</head>

<body class="full-screen">
	<nav class="navbar navbar-default navbar-fixed-top"></nav>
	<div class="container full-screen">
		<div class="row full-screen">
			<div class="col-md-3">
				<div class="a-menu nav flex-column nav-pills menu-height"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<button type="button" class="btn btn-secondary" id="btninserimenti">Inserimenti</button>
					<div id="div_inserimenti" class="hide">
						<a class="nav-link"
							href="http://localhost:8080/frontend/inserimentosocio.html"
							target="main_iframe">Inserisci Socio</a> <a class="nav-link"
							href="http://localhost:8080/frontend/inserimentomodello.html"
							target="main_iframe">Inserisci Modello</a> <a class="nav-link"
							href="http://localhost:8080/frontend/inserimentoimbarcazione.html"
							target="main_iframe">Inserisci Imbarcazione</a> <a
							class="nav-link"
							href="http://localhost:8080/frontend/inserimentotecnico.html"
							target="main_iframe">Inserisci tecnico</a> <a class="nav-link"
							href="http://localhost:8080/frontend/inserimentotest.html"
							target="main_iframe">Inserisci test</a> <a class="nav-link"
							href="http://localhost:8080/frontend/inserimentopersonalemarittimo.html"
							target="main_iframe">Inserisci Personale Marittimo</a> <a
							class="nav-link"
							href="http://localhost:8080/frontend/inserimentotesteseguito.html"
							target="main_iframe">Inserisci test eseguito</a> <a
							class="nav-link"
							href="http://localhost:8080/frontend/inserimentochicomanda.html"
							target="main_iframe">Indica chi comanda</a>
					</div>

					<button type="button" class="btn btn-secondary" id="btnarchivi">Archivi</button>
					<div id="div_archivi" class="hide">
						<a class="nav-link"
							href="http://localhost:8080/frontend/archiviosoci.html"
							target="main_iframe">Archivio Soci</a> <a class="nav-link"
							href="http://localhost:8080/frontend/archivioimbarcazioni.html"
							target="main_iframe">Archivio Imbarcazioni</a>
					</div>
					<!--                <a class="nav-link" href="http://localhost:8080/frontend/gotocheckout.html" target="main_iframe">TestInsertion</a>
                    <a class="nav-link" href="http://localhost:8080/frontend/gotocheckouttemplate.html" target="main_iframe">TestInsertion Template</a>
                    <a class="nav-link" href="http://localhost:8080/frontend/gotoarchive.html" target="main_iframe">Archive</a>-->
				</div>
			</div>
			<iframe id="main_iframe" name="main_iframe"
				class="col-md-9 full-screen"></iframe>
		</div>
	</div>

	<footer class="page-footer font-small blue pt-4 mt-4">
		<div class="container-fluid text-center text-md-left">
			<div class="row">
				<div class="col-md-6">
					<h5 class="text-uppercase">Studente</h5>
					<ul class="list-unstyled">
						<li><label>Coppi Francesco</label></li>
					</ul>
				</div>
				<div class="col-md-6">
					<h5 class="text-uppercase">Matricola</h5>
					<ul class="list-unstyled">
						<li><label>640690</label></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>