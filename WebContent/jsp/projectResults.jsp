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
<script type="text/javascript">
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
 

</script>
<title>Project Results</title>
</head>
<body>
  	<c:if test="${not loginResult}">
	    <p>Login Unsuccessful: ${Message}</p>
	    
  	</c:if>
	<c:if test="${loginResult}">
		<h3 style="text-align:center">${ProjectName}</h3>
		<h3 style="text-align:center">ID: ${ProjectID} </h3>
		<button type="button" name="back" onclick="history.back()">Go back</button>
		<h3 style="text-align:center">Assignment List</h3>
		
		<table class="CSSTableGenerator">
    	<thead>
      	<tr>
	        <th>Aid</th>
        	<th>Title</th>
        	<th>Task</th>
        	<th>ID of User Responsible</th>
       </tr>
    	</thead>
    	<tbody>
    	
    	
    	<c:forEach items="${assignmentList}" var="item">
			      <tr>
	        	<td>${item.assignmentID}</td>
        		<td>${item.title}</td>
        		<td>${item.task}</td>
        		<td> ${item.userID}</td>
        	
      		</tr>
      	</c:forEach>
    	
	
	    </tbody>
  	</table>
		
  	
  	<div class="divLeft">	
  	<h3>Make a New Assignment</h3>
  	<form action="/ClassCoor/MakeAssignment" method="get" class="elegant-aero">
  	<label>
		<span>Title:</span> <input type="text" name="Title" placeholder="Title">
	</label>	
		<br/>
		<br/>
	<label>
		<span>Task:</span> <input type="text" name="Task" placeholder="Task"><br/>
	</label>
		<br/>
	<label>
		<span>ProjectID:</span> <input type="text" name="ProjID" value= "${ProjectID}" readonly><br/>
		<br/>
	</label>
	<label>
		<span>UserID who's responsible:</span> <input type="text" name="UserID" placeholder="UserID"><br/>
		<br/>
	</label>
		<input type="submit" value="Add Assignment!">
	</form>
	</div>
	

	<!--  
	<div class="divRight">
	<h3>Update Assignment</h3>
	<form action="/ClassCoor/UpdateAssignment" method="get" onsubmit="return validateCreateAssignment(this);">
		AID for assignment you want to update : <input type="text" name="AssignmentID"><br/>
		<br/>
		Update task to: <input type="text" name="Task" maxlength="200"><br/>
		<br/>
		ProjectID: <input type="text" name="ProjID" value= "${ProjectID}" readonly><br/>
		<br/>
		Your ID <input type="text" name="UserID" value= "${UserID}" readonly><br/>
		<br/>
		<input type="submit" value="Update">
	</form>
	</div> -->
	
	<div class="divRight">	
  	<h3>Update Assignment</h3>
  	<form action="/ClassCoor/UpdateAssignment" method="get" class="elegant-aero" onsubmit="return validateCreateAssignment(this);">
  	<label>
		<span>AID for assignment you want to update: </span> <input type="text" name="AssignmentID" placeholder="AID">
	</label>	
		<br/>
		<br/>
	<label>
		<span>Update task to: </span> <input type="text" name="Task" maxlength="200" placeholder="Task"><br/>
	</label>
		<br/>
	<label>
		<span>ProjectID: </span> <input type="text" name="ProjID" value= "${ProjectID}" readonly><br/>
		<br/>
	</label>
	<label>
		<span>Your ID: </span> <input type="text" name="UserID" value= "${UserID}" placeholder="UserID" readonly><br/>
		<br/>
	</label>
		<input type="submit" value="Update">
	</form>
	</div>
		
		
		
		
	</c:if>

</body>
</html>