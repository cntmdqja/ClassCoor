<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">
<title>Login Wrong</title>
</head>
<body>
	<div class="centralDiv">
		<p>Username doesn't exist or password is wrong</p>
			<br/>
		<a href="jsp/index.jsp">Go back to Login page</a><br/>
		<a href="jsp/NewUser.jsp">Make a new Account</a>
	</div>

</body>
</html>