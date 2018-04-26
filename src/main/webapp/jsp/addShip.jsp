<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project(Add Ship)</title>
</head>
<body>

	<div align="center">
		<img src="header.png" alt="Logo">
	</div>

	<div class="add">

		<form:form modelAttribute="shipAdd">

			<label for="ship">Ship Name:</label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>

			<label for="passengers">Passengers:</label>
			<form:input path="passengers"></form:input>
			<form:errors path="passengers"></form:errors>

			<label for="cost">Cost:</label>
			<form:input path="cost"></form:input>
			<form:errors path="cost"></form:errors>

			<label for="metres">Metres:</label>
			<form:input path="metres"></form:input>
			<form:errors path="metres"></form:errors>

			<input type="submit" value="Add" /><

			<a href="/">Home</a>
		</form:form>
	</div>
</body>
</html>