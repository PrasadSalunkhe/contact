<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application one</title>
</head>
<body>
	<h2>Contact Form</h2>

	<font color='green'>${succMsg}</font>
	<font color='red'>${errMsg}</font>

	<%--In modelAttribute contactObj is key specified in viewPage method in SaveContactController  --%>
	<form:form action="/saveContact" method="POST"
		modelAttribute="contactObj">

		<table>
			<tr>
				
				<td>Contact Name</td>
				<%-- contactName is field of DTO --%>
				<td><form:input path="contactName" /></td>
				<form:hidden path="contactId" />
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactNumber" /></td>
			</tr>

			<tr>
				<%-- submit is action here and value=submit is name displayed on fronted--%>
				<td><input type="submit" value="submit"></td>

			</tr>


		</table>

	</form:form>

	<a href="/viewContacts">View All Contacts</a>

</body>
</html>