
function validate(form){
	var projID = form.ProjID.value;
	var password = form.ProjPassword.value;
	var errors = [];
	if (!checkLength(projID)) {
		errors.push("You must enter a username.");
	}
	if (!checkLength(password)) {
		errors.push("You must enter a password.");
	}
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}


function validateCreate(form){
	var projectName = form.ProjectName.value;
	var pass = form.ProjPassword.value;
	var errors = [];
	if (!checkLength(projectName)) {
		errors.push("You must enter a username.");
	}
	if (!checkLength(pass)) {
		errors.push("You must enter a password.");
	}
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}

function validateLogin(form){
	var name = form.UserName.value;
	var password = form.Password.value;
	var errors = [];
	if (!checkLength(name)) {
		errors.push("You must enter a username.");
	}
	if (!checkLength(password)) {
		errors.push("You must enter a password.");
	}
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}

function ProjectValidateLogin(form){
	var ID = form.ProjID.value;
	var password = form.ProjPassword.value;
	var errors = [];
	if (!checkLength(ID)) {
		errors.push("You must enter a ID.");
	}
	if (!checkLength(password)) {
		errors.push("You must enter a password.");
	}
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}

function validateNewAccount(form){
	var name = form.UserName.value;
	var password = form.Password.value;
	var password2 = form.Password2.value; 
	var errors = [];
	if (!checkLength(name)) {
		errors.push("You must enter a username.");
	}
	if (!checkLength(password)) {
		errors.push("You must enter a password.");
	}
	if (!checkLength(password2)) {
		errors.push("You must enter a password for confirmation.");
	}
	if(password!=password2)	{
		errors.push("Passwords do not match");
	}
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}

function validateCreateAssignment(form){
	var task = form.Task.value;
	var errors = [];
	if (!checkLength(task)) {
		errors.push("You must enter a task description");
	}
	
	if (errors.length > 0) {
		reportErrors(errors);
		return false;
	}
	return true;
}



function checkLength(text, min, max){
		min = min || 1;
		max = max || 10000;
		if (text.length < min || text.length > max) {
			return false;
		}
		return true;
	}
function reportErrors(errors){
		var msg = "There were some problems...\n";
		var numError;
		for (var i = 0; i<errors.length; i++) {
			numError = i + 1;
			msg += "\n" + numError + ". " + errors[i];
		}
		alert(msg);
	}
