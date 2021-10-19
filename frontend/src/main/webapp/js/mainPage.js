$(document).ready(function() {
	$(document).on("click","a.nav-link",function(){
        $("a.nav-link").removeClass("active");
        $(this).addClass("active");
    });
	
	$(document).on("click","#btninserimenti",function(){
		$("#div_inserimenti").removeClass("hide")
		$("#div_archivi").addClass("hide")
	});
	
	$(document).on("click","#btnarchivi",function(){
		$("#div_inserimenti").addClass("hide")
		$("#div_archivi").removeClass("hide")
	});
});