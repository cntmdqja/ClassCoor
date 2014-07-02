<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">
<title>LogOut</title>
</head>
<body>
	<div class="centralDiv">
	<%@ page session="true"%>

	<p>User ${User.userName} has been logged out.</p><br/>
	<a href="index.jsp">Go back to Log In Page</a>
	<% session.invalidate(); %>
	</div>

</body>
</html>