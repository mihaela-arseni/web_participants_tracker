<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>

<head>

	<title>IT event</title>

	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>"How to start a career in IT" - online event</h2>
		</div>
	</div>

	<div id="container">
		<h3>Choose an option: </h3>
		<br></br>
		
		<form:form action="search" method="GET">
         	Search participant: <input type="text" name="theName" />             
         	<input type="submit" value="Search" class="add-button" />        	
        </form:form>
		
		<input type="button" value="Add participant"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
		/>
		
		<input type="button" value="Delete participant"
			onclick="window.location.href='showFormForDelete'; return false;"
			class="add-button"
		/>
				
		<table>	
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
					
			</tr>
				
			<!-- loop over the list and print the participants, based on attribute name from model -->
			<c:forEach var="tempParticipant" items="${participants}">
	
				<c:url var="updateLink" value="/participant/saveUpdates">
					<c:param name="participantId" value="${tempParticipant.id} "/>
				</c:url>
			
	
			<!-- retrieve data for each participant, will call getters for each field -->
				<tr>
					<td> ${tempParticipant.firstName}</td>
					<td> ${tempParticipant.lastName}</td>
					<td> ${tempParticipant.email}</td>
					
					<td>
						<!-- Display the update link -->
						<a href="${updateLink}"
							>Update</a>	

					</td>
				</tr>
			
			</c:forEach>
		</table>
									
	</div>
	
</body>

</html>