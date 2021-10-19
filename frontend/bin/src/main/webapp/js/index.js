$(document).ready(function() {

	$("#form-sign-in").submit(function(e){
		$.post($("#form-sign-in").attr("action"), $("#form-sign-in").serialize(),function(data) {
					
			if(!!data.Validated && data.Validated === "1")
				alert("FINE")
			else 
				alert("non finisce mai ")
		});
		return false;
	});
});