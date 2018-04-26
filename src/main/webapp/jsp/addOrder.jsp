<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project(Add Ship)</title>
</head>
<body>
	<h1>Add Ship</h1>
	<div class="add">
		<form:form modelAttribute="orderAdd">

			<label for="ship">Ships:</label>
			<form:select path="ship" items="${shipList}" />

			<label for="comp">Companies:</label>
			<form:select path="ShippingCompany" items="${companyList}" />

			<label for="lname">Last Name</label>
			<input type="submit" value="Order Ship" />


			<a href="/">Home</a>
		</form:form>
	</div>
</body>
</html>