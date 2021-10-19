$(document).ready(function() {
	
	$.post($("#form-no-pwd").attr("action"), $("#form-no-pwd").serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			$("#username").val("nopwd");
			$("#pwd").val("nopwd");
			$.post($("#form-sign-in").attr("action"), $("#form-sign-in").serialize(),function(data) {
				$("#clickme")[0].click();
			});
		} else {
			$("#div_login").removeClass("hide");
		}
	});
	$("#form-sign-in").submit(function(e){
	
		$("#errorDiv").addClass("hide");
		$.post($("#form-sign-in").attr("action"), $("#form-sign-in").serialize(),function(data) {
			if(!!data.code && data.code === "0") {
				$("#clickme")[0].click();
			}
			else {
				$("#errorDiv").removeClass("hide")
				$("#errorDivMsg").html(data.msg);
			}
		});
		//
		return false;
	});
});