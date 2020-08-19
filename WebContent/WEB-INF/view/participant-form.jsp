<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>

<html>
<head>
<meta charset="ISO-8859-1">

<title>Save participant</title>

	<link type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
	<link type="text/css" 
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-participant-style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>"How to start a career in IT" - online event</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Participant</h3>
	
		<form:form action="saveParticipant" modelAttribute="participant" method="POST">
			
			<!-- Associate this data with participant id -->
			<form:hidden path="id" />
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>	
					
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>	
							
				</tbody>	
			</table>
					
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/participant/welcome">Home Page</a>
		</p>
	
	</div>

</body>
</html>