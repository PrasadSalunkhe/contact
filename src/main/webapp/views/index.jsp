<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>phone book app</title>
</head>
<body>
<h1>Welcome to a Phone Book Application</h1>

<font color='green'>${succMesg}</font>
<font color='red'>${errMesg}</font>

<form:form action="saveContact" method="Post" modelAttribute="contact">

<table>
<tr>
<td>Contact Name</td>
<td><form:input path="cname"/></td>
</tr>

<tr>
<td>Contact Email</td>
<td><form:input path="cemail"/></td>
</tr>

<tr>
<td>Contact Number</td>
<td><form:input path="cnum"/></td>
</tr>


<tr>
<td><input type="submit" value="Save Contact"/></td>
</tr>
</table>

</form:form>

<a href="viewContacts">View All Contacts</a>
</body>
</html>