<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="jsp/validation.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>

<!--  <div class="centralDiv">
	<form action="/ClassCoor/NewUser" method="post" onsubmit="return validateNewAccount(this);">
		Username: <input type="text" name="UserName"><br/>
		<br/>Password: <input type="text" name="Password"><br/>
		<br/>Confirm Password: <input type="text" name="Password2"><br/>
		<input type="submit" value="Create">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" name="back" onclick="history.back()">Go back</button>
	</form>
</div> -->


<br><br><br><br><br>
<form action="/ClassCoor/NewUser" method="post" class="elegant-aero" onsubmit="return validateNewAccount(this);">
  	<label>
		<span>Username:</span> <input type="text" name="UserName">
	</label>	
		<br/>
	<label>
		<span>Password:</span> <input TYPE=PASSWORD name="Password"><br/>
	</label>
		<br/>
		<label>
		<span>Confirm Password:</span> <input type="text" name="Password2"><br/>
	</label>
		<br/>
		<input class="newUserButton" style="float:left" type="submit" value="Create">
		<button class="newUserButton" style="float:right" type="button" name="back" onclick="history.back()">Go back</button>
	</form>
</body>
</html>