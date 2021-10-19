var toForm = "#inserisci-chicomanda-form";

$(document).ready(function(){
	$.post($("#get-capitani-form").attr("action"), $("#get-capitani-form").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			select = document.getElementById('capitano');
			let opt = document.createElement('option');
		    opt.value = "";
		    opt.innerHTML = "";
		    select.appendChild(opt);
		    
			for (var i = 0; i<data.capitani.length; i++){
			    let opt = document.createElement('option');
			    opt.value = data.capitani[i]['codiceFiscale'];
			    opt.innerHTML = data.capitani[i]['cognome'] + ' ' + data.capitani[i]['nome'];
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
				$("#maindiv").removeClass("hide");
			});
		}
	});
});
