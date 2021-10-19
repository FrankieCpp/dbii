var toForm = "#inserisci-testeseguito-form";

$(document).ready(function(){
	$.post($("#get-imbarcazioni-form").attr("action"), $("#get-imbarcazioni-form").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			select = document.getElementById('imbarcazione');
			let opt = document.createElement('option');
		    opt.value = "";
		    opt.innerHTML = "";
		    select.appendChild(opt);
		    
			for (var i = 0; i<data.imbarcazioni.length; i++){
			    let opt = document.createElement('option');
			    opt.value = data.imbarcazioni[i]['matricola'];
			    opt.innerHTML = data.imbarcazioni[i]['matricola'];
			    select.appendChild(opt);
			}
		}
		$.post($("#get-tecnici-form").attr("action"), $("#get-tecnici-form").serialize(),function(data) {
			if(!!data.code && data.code === "0") {
				select = document.getElementById('tecnico');
				let opt = document.createElement('option');
			    opt.value = "";
			    opt.innerHTML = "";
			    select.appendChild(opt);
			    
				for (var i = 0; i<data.tecnici.length; i++){
				    let opt = document.createElement('option');
				    opt.value = data.tecnici[i]['codiceFiscale'];
				    opt.innerHTML = data.tecnici[i]['nome'] + ' ' + data.tecnici[i]['cognome'];
				    select.appendChild(opt);
				}
				$.post($("#get-test-form").attr("action"), $("#get-test-form").serialize(),function(data) {
					if(!!data.code && data.code === "0") {
						select = document.getElementById('test');
						let opt = document.createElement('option');
					    opt.value = "";
					    opt.innerHTML = "";
					    select.appendChild(opt);
					    
						for (var i = 0; i<data.test.length; i++){
						    let opt = document.createElement('option');
						    opt.value = data.test[i]['codice'];
						    opt.innerHTML = data.test[i]['nome'];
						    select.appendChild(opt);
						}
						$("#maindiv").removeClass("hide");
					}
				});

			}
		});
	});
});
