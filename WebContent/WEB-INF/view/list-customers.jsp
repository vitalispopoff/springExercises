<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

	<html>
		<head>		
			<title>List Customers</title>
			
			<!-- link the css file -->
			<link 
				type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" 
			/>
					
		</head>
	
		<body>
		
			<div id="wrapper">
				<div id="header">
					<h2>CRM - Customer Relationship Manager</h2>
				</div>
			</div>
			
			<div id="container">
				<div id="content">
					
					<!-- upper menu: add customer | search -->
					<table>
						<tr>
							<td>
								<!-- "add a customer" button  -->				
								<input 
									type="button" 
									value="Add Customer"
									onclick="window.location.href='showFormForAdd'; return false;"
									class="add-button"/>
							</td>					
							<td>
								<!-- the search box  -->
								<form:form action="search" method="GET">
									Search by name:
									<input 
										type="text"
										name="theSearchName" />
									<input
										type="submit"
										value="Search"
										class="add-button" />
								</form:form>
							</td>
						</tr>
					</table>
					
					<!-- add out html table here -->				
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					
						<!-- loop over and print the customers -->
						<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- constructing an update link with customer.id ;  -->						
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<!-- constructing a delete link with customer.id ;  -->						
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>								
										 
							<tr>
								<td> ${tempCustomer.firstName}</td>
								<td> ${tempCustomer.lastName}</td>
								<td> ${tempCustomer.email}</td>
								<td> <!-- display the update link -->
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are You sure to delete the customer?'))) return false">Delete</a>	<!-- onclick provides a JS piece prompting a approval window -->
								</td> 
							</tr>
						
						</c:forEach>
								
					</table>
				
				</div>
			</div>
								
		</body>
	</html>