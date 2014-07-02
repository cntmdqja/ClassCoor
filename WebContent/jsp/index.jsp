<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="jsp/validation.js" type="text/javascript"></script>
<title>Login</title>
</head>
<body>
	<div class="indexTop">
		<h1>Class Coordinator</h1>
	</div>


  	<form action="/ClassCoor/Project" method="post" class="elegant-aero" style="width:30%" onsubmit="return validateLogin(this);">
  	<label>
		<span>Username:</span> <input type="text" name="UserName">
	</label>	
		<br/>
	<label>
		<span>Password:</span> <input TYPE=PASSWORD name="Password"><br/>
	</label>
		<br/>
		<input class="newUserButton" style="float:left" type="submit" value="Login">
		<a class="newUserButton" style="float:right" href='jsp/NewUser.jsp'>Sign Up</a>
	</form>



</body>
</html>
