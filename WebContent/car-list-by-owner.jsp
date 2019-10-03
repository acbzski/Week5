<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Lists</title>
<style>
body {
	background-color: darkslategray;
	color: snow;
	font-family: sans-serif;
}
a {color: snow;}
a:visited {color: snow;}
</style>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr><td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.listName}</h2></td></tr>
		<tr><td colspan="3">Sale Date: ${currentlist.sellDate}</td></tr>
		<tr><td colspan="3">Owner: ${currentlist.owner.ownerName}</td></tr>
		<c:forEach var="listVal" items="${currentlist.listOfCars}">
			<tr><td></td><td colspan="3">
				${listVal.year} ${listVal.make} ${listVal.model}
				</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
<input type="submit" value="Edit List" name="doThisToCar">
<input type="submit" value="Delete List" name="doThisToCar">
</form>
<a href="addCarsForListServlet">Create a new list</a><br />
<a href="index.html">Add a new car</a>
</body>
</html>