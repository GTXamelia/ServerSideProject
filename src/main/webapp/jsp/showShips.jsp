<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table {
	width: 45%;
}

table tr {
	background-color: #222222;
	color: white;
}

table th {
	background-color: #FECB00;
	color: black;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SS RAD Final Project (Ships)</title>
</head>
<body>
	<h1>Ship</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Passengers</th>
				<th>Cost</th>
				<th>Length(Metres)</th>
				<th>Shipping Company</th>
			</tr>
			<c:forEach items="${ships}" var="ships">
				<tr>
					<td>${ships.name}</td>
					<td>${ships.passengers}</td>
					<td>${ships.cost}</td>
					<td>${ships.metres}</td>
					<td>${ships.shippingCompany.name}</td>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>