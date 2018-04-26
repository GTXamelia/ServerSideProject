<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project(Add Shipping Company)</title>
</head>
<body>

	<div align="center">
		<img src="header.png" alt="Logo">
	</div>

	<div class="add">
		<form:form modelAttribute="companyAdd">

			<label for="name">Company Name:</label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>

			<label for="home">Home Port:</label>
			<form:input path="homePort"></form:input>
			<form:errors path="homePort"></form:errors>

			<label for="balance">Balance:</label>
			<form:input path="balance"></form:input>
			<form:errors path="balance"></form:errors>

			<input type="submit" value="Add" />

			<a href="/">Home</a>
		</form:form>
	</div>
</body>
</html>