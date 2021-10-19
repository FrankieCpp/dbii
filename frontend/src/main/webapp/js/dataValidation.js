window.addEventListener('load', function () {
//	Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.getElementsByClassName('needs-validation');

//	Loop over them and prevent submission
	var validation = Array.prototype.filter.call(forms, function (form) {
		form.addEventListener('submit', function (event) {
			event.preventDefault();
			event.stopPropagation();
			if (form.checkValidity() && typeof execute == 'function'){
				execute(event);
			}
			form.classList.add('was-validated');
		}, false);
	});
}, false);

var toForm = "";
var execute = function(event){
	$("#errorDiv,#successDiv").addClass("hide");
	$.post($(toForm).attr("action"), $(toForm).serialize(),function(data) {
		if(!!data.code && data.code === "0") {
			$("#successDiv").removeClass("hide")
		}
		else {
			$("#errorDiv").removeClass("hide")
			$("#errorDivMsg").html(data.msg);
		}
	});
}