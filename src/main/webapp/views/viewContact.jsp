<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts Page</title>

<script>
	function deleteConfirm(){  
		return confirm("Are you sure want to delete ? "); 
	}
</script>

</head>
<body>
	<h1>Your List Of Contact</h1>
	<a href="/"> + add new Contact</a>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Mob.Number</th>
			<th>Actions</th>
		</tr>
		<%--for each method in frontend --%>
		<%--items="${allcontacts}" is a key in model attribute , var="contact" here contact is just variable name we can take any  --%>
		<c:forEach items="${allcontacts}" var="contact">
			<tr>
				<%-- variables from pojo--%>
				<td>${contact.contactName }</td>
				<td>${contact.contactEmail }</td>
				<td>${contact.contactNumber }</td>
				<td><a href="/updateContact?cid=${contact.contactId }">Edit</a> 
				<a href="/deleteContact?cid=${contact.contactId }"
					onclick="return deleteConfirm()">Delete </a>
				</td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>