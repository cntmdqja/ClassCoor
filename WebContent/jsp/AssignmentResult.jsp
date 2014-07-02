<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%= request.getContextPath() %>/jsp/style.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="jsp/validation.js" type="text/javascript"></script>
<title>Assignment Result</title>
</head>
<body>
	<div class="centralDiv" style="text-align:center">
	<c:choose>
		<c:when test="${Type=='Make'}">
	    	<h1>YOU SUCCESSFULLY MADE ASSIGNMENT!</h1>
	    </c:when>
		<c:when test="${Type=='Update'}">
	    	<c:if test="${success}">
	    		<h1>YOU SUCCESSFULLY UPDATED YOUR ASSIGNMENT!</h1>
	    	</c:if>
	    	
	    	<c:if test="${not success}">
	    		<h1>Unsuccessful: ${Message}</h1>
	    	</c:if>
	    </c:when>
	</c:choose>
	</br>
	</br>
	<button type="button" name="back" onclick="history.go(-1)">Go back</button>
	
	
	
	
	
	
	</div>



</body>
</html>