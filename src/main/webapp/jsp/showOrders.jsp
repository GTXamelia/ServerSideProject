<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
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
					<td>${orders.oid}</td>
					<td>${orders.shippingCompany.name}</td>
					<td>${orders.ship.name}</td>
					<td>${orders.date}</td>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>