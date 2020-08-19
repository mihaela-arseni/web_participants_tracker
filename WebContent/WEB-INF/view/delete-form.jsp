<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>

<head>

	<title>Delete Participants</title>

	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>"How to start a career in IT" - online event</h2>
		</div>
		
		<br></br>
		<h3>List of participants</h3>
		
	</div>

	<div id="container">
		
		<div id="content">
			<form:form action="search" method="GET">
                Search participant: <input type="text" name="theName" />             
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
			<table>	
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
					
				</tr>
				
			<!-- loop over the list and print the participants, based on attribute name from model -->
			<c:forEach var="tempParticipant" items="${participants}">
	
				<c:url var="deleteLink" value="/participant/deleteParticipant">
					<c:param name="participantId" value="${tempParticipant.id} "/>
				</c:url>
	
				
			<!-- retrieve data for each participant, will call getters for each field -->
				<tr>
					<td> ${tempParticipant.firstName}</td>
					<td> ${tempParticipant.lastName}</td>
					<td> ${tempParticipant.email}</td>
				
				
					<td>
						<!-- Display the update link -->
						<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this participant?'))) return false">Delete</a>	

					</td>
				</tr>
			</c:forEach>
			</table>
			
			<p>
				<a href="${pageContext.request.contextPath}/participant/welcome">Home Page</a>
			</p>
		</div>
		
	</div>
	
	
</body>


</html>