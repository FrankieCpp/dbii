var toForm = "#inserisci-imbarcazione-form";

$(document).ready(function(){
	$.post($("#get-soci-form").attr("action"), $("#get-soci-form").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			select = document.getElementById('socio');
			let opt = document.createElement('option');
		    opt.value = "";
		    opt.innerHTML = "";
		    select.appendChild(opt);
		    
			for (var i = 0; i<data.soci.length; i++){
			    let opt = document.createElement('option');
			    opt.value = data.soci[i]['codiceFiscale'];
			    opt.innerHTML = data.soci[i]['codiceFiscale'];
			    select.appendChild(opt);
			}
			$.post($("#get-modelli-form").attr("action"), $("#get-modelli-form").serialize(),function(data) {
				if(!!data.code && data.code === "0") {
					select = document.getElementById('modello');
					let opt = document.createElement('option');
				    opt.value = "";
				    opt.innerHTML = "";
				    select.appendChild(opt);
				    
					for (var i = 0; i<data.modelli.length; i++){
					    let opt = document.createElement('option');
					    opt.value = data.modelli[i]['codice'];
					    opt.innerHTML = data.modelli[i]['codice'];
					    select.appendChild(opt);
					}
				}
			});
			$("#maindiv").removeClass("hide");

		}
	});
});
