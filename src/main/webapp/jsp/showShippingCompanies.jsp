<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SS RAD Final Project (Company)</title>
</head>
<body>
	<h1>Company</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Home Post</th>
				<th>Cost</th>
			</tr>
			<c:forEach items="${companies}" var="companies">
				<tr>
					<td>${companies.name}<tv>
					<td>${companies.homePort}<tv>
					<td>${companies.balance}<tv>
					<td>${companies.ships}<tv>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>