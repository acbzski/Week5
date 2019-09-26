<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Show Room - All Cars</title>
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
<h3>All Cars</h3>
<form action="navigationServlet" method="post">
<table>
<c:forEach items="${requestScope.allCars}" var="currentcar">
<tr>
	<td><input type="radio" name="id" value="${currentcar.id}"></td>
	<td>${currentcar.year}</td>
	<td>${currentcar.make}</td>
	<td>${currentcar.model}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit" name="doThisToCar">
<input type="submit" value="Delete" name="doThisToCar">
<input type="submit" value="Add" name="doThisToCar">
</form>
</body>
