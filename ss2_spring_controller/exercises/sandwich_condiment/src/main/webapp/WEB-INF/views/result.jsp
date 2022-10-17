<%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/14/2022
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SandWich Condiments</h1>
<form action="/result" style="background-color: antiquewhite; width: 30%">
    <input name="condiment" value="" hidden>
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts <br><br>
    <input type="submit" value="Save">
</form>
<b>Condiment:</b>
<c:forEach items="${condiment}" var="condiment">
    <p>${condiment}</p>
</c:forEach>

</body>
</html>
