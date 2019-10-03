<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New List</title>
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
<form action="createNewListServlet" method="post">
List Name:<input type="text" name="listName"><br />
Sale date:<input type="text" name="month" placeholder="mm" size="4"> <input type="text" name="day" placeholder="dd"size="4">, <input type="text" name="year" placeholder="yyyy" size="4"><br />
Owner Name:<input type="text" name="ownerName"><br />
Available Cars:<br />
<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.year} ${currentitem.make} ${currentitem.model}</option>
</c:forEach>
</select><br />
<input type="submit" value="Create List and Add Cars">
</form>
<a href="index.html">Go add new cars instead.</a>
</body>
</html>