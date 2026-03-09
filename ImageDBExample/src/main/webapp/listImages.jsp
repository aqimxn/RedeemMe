<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Photo</th>
		</tr>
		<c:forEach items="${images}" var="image">
			<tr>
				<td><c:out value="${image.id}" /></td>
				<td><img src="data:image/jpg;base64,${image.photo}" width="100px" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<!-- Author: FES -->