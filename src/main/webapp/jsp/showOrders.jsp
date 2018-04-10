<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SS RAD Final Project (Orders)</title>
</head>
<body>
	<h1>Orders</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Order Number</th>
				<th>Shipping Company Name</th>
				<th>Ship Name</th>
				<th>Order Date</th>
			</tr>
			<c:forEach items="${orders}" var="orders">
				<tr>
					<td>${orders.oid}<tv>
					<td>${orders.shippingCompany.name}<tv>
					<td>${orders.ship.name}<tv>
					<td>${orders.date}<tv>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>