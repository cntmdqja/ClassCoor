<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
		  $("#MakeProj").click(function(){
		    $("#CreateProj").slideToggle();

		  });
	});
	</script>
<script src="jsp/validation.js" type="text/javascript"></script>

<title>Login Result</title>
</head>


<body>
<div class="centralDiv" style="width:100%;text-align:center">
	<h1>Welcome Back ${User.userName}</h1>
	<a href='jsp/LogOut.jsp'>Sign Out</a>
	</div>
	
	<div class="divCenter">
	<div class="divLeft">
		<form action="/ClassCoor/ProjFind" method="post" class="elegant-aero" onsubmit="return ProjectValidateLogin(this);">
		<h3>Find an existing project</h3>
		<br>
  	<label>
		<span>Project ID#: </span> <input type="text" name="ProjID">
	</label>	
		<br/>
	<label>
		<span>Password: </span> <input TYPE=PASSWORD name="ProjPassword"><br/>
	</label>
		<br/>
		<label>
		<span>Your ID: </span> <input type="text" name="userID" value= "${User.userID}" readonly><br/>
	</label>
		<br/>
		<input class="newUserButton" style="float:left" type="submit" value="Find">
	</form>
	</div>
	
	
	<div class="divRight">
		<form action="/ClassCoor/ProjCreate" method="post" class="elegant-aero" onsubmit="return validateCreate(this);">
		<h3>Create a project</h3>
		<br>
  	<label>
		<span>Project Name: </span> <input type="text" name="ProjextName">
	</label>	
		<br/>
	<label>
		<span>Password: </span> <input type="text" name="ProjPassword"><br/>
	</label>
		<br/>
		<label>
		<span>LeaderName: </span> <input type="text" name="userCreate" value= "${User.userName}" readonly><br/>
	</label>
		<br/>
		<label>
		<span>LeaderID (Your ID): </span> <input type="text" name="userID" value= "${User.userID}" readonly><br/>
	</label>
		<br/>
		<input class="newUserButton" style="float:left" type="submit" value="Create">
	</form>
	</div>
	
	</div>
  	

</body>
</html>