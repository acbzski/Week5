<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Show Room - Edit a Car</title>
<style>
body {
	background-color: darkslategray;
	color: snow;
	font-family: sans-serif;
}
</style>
</head>
<body>
<h1>Car Show Room</h1>
<h3>Edit A Car</h3>
<form action="editCarServlet" method="post">
Year: <input type="number" name="year" min=1885 max=2020 value="${carToEdit.year}">
Make: <input type="text" name="make" value="${carToEdit.make}">
Model: <input type="text" name="model" value="${carToEdit.model}"><br />
<input type="hidden" name="id" value="${carToEdit.id}">
<input type="submit" value="Save Edited Car">
</form>
</body>
</html>