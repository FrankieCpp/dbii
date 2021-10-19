var toForm = "#inserisci-tecnico-form";

$(document).ready(function(){

	$.post($("#get-modelli-form").attr("action"), $("#get-modelli-form").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			select = document.getElementById('modelli');
			for (var i = 0; i<data.modelli.length; i++){
			    let opt = document.createElement('option');
			    opt.value = data.modelli[i]['codice'];
			    opt.innerHTML = data.modelli[i]['codice'];
			    select.appendChild(opt);
			}
			$(document).ready(function() {
			    $('.mdb-select').material_select();
			});
		}
	});
});
