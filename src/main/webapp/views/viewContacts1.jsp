<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
</head>
<body>
	<h1>View Contacts Here</h1>

	<a href="/">+Add New Contact</a>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${contacts}" var="con">
			<tr>
				<td>${con.cname}</td>
				<td>${con.cemail}</td>
				<td>${con.cnum}</td>
				<td><a href="editContact?contactid=${con.cid}">Edit</a> 
				<a href="#">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>