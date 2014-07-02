<!-- 	
<html:html>
  <head><title>Logon Form</title></head>
  <body>
  <html:messages id="error" message="false" header="errors.header" footer="errors.footer">
	<li><c:out value="${error}"></c:out></li>
  </html:messages>
	<h2>Logon Example - Logon to JavaTunes</h2>
	
	<html:form action="/login">
	Name: <html:text property="name"/> <br/>
	Password: <html:password property="password"/> <br/>
	<html:submit value="Login"/>
	</html:form>

  </body>
</html:html>
-->


<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
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
<div class="login">
	<html:messages id="error" message="false" header="errors.header" footer="errors.footer">
		<li><c:out value="${error}"></c:out></li>
    </html:messages>
	<html:form action="/ClassCoor/Project" method="post" onsubmit="return validateLogin(this);">
		Username: <html:text name="UserName" property="name"/><br>
		<br>
		Password: <html:text name="Password" property="password"/><br><br>
		<input type="submit" value="Login"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <a href='jsp/NewUser.jsp'>Sign Up</a>
	</html:form>
</div>


</body>
</html:html>
 -->

