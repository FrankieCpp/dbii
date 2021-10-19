$(document).ready(function(){
	$(document).on("click","#filter-button",function(){
        $("#tableResult").addClass("hide");
        $.post($("#test-archive-form").attr("action"),$("#test-archive-form").serialize(), function(data){
        	$("#tableResult").html(data).removeClass("hide");	
        });
    });
});
