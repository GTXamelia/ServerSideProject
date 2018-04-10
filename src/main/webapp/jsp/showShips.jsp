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
	<title>SS RAD Final Project (ships)</title>
</head>
<body>
	<h1>Ship</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Passangers</th>
				<th>Cost</th>
				<th>Length(Metres)</th>
				<th>Shipping Company</th>
			</tr>
			<c:forEach items="${ships}" var="ships">
				<tr>
					<td>${ships.name}<tv>
					<td>${ships.passengers}<tv>
					<td>${ships.cost}<tv>
					<td>${ships.metres}<tv>
					<td>${ships.shippingCompany.name}<tv>
					
				</tr>
			</c:forEach>
		</table>
	<a href="/">Home</a>
</body>
</html>