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
	<h1>Ship</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Home Port</th>
				<th>Balance</th>
				<th>Ship</th>
			</tr>
			<c:forEach items="${comp}" var="comp">
				<tr>
					<td>${comp.name}<td>
					<td>${comp.homePort}<td>
					<td>${comp.balance}<td>
					<td>
						<c:forEach items="${comp.ships}" var="comp">
							<td>${ships.name}<td>
						</c:forEach>
					<td>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>