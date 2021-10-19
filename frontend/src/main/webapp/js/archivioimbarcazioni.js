$(document).ready(function(){
	$(document).on("click","#filter-button",function(){
		$("#tableResult").addClass("hide");
		$.post($("#test-archive-form").attr("action"),$("#test-archive-form").serialize(), function(data){
			$("#tableResult").html(data).removeClass("hide");	
		});
	});
});

function dettaglioImbarcazione(matricola, i){
	$("#matricola").val(matricola);
	
	$.post($("#dettaglio-imbarcazioni-form").attr("action"), $("#dettaglio-imbarcazioni-form").serialize(),function(data) {			
		$("#dettaglioImbarcazione").removeClass("hide").html(data);
	});
}
