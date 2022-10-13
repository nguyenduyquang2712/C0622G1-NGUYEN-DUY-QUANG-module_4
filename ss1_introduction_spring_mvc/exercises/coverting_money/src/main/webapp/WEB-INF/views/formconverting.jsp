<%--
  Created by IntelliJ IDEA.
  User: QUANG
  Date: 10/13/2022
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Converting Money</h2>
<form action="/result">
    <input type="number" name="usd" value="${usd}"> USD <br> <br>
    <input type="submit" value="Convert">
    <p>USD: ${usd}</p>
    <p>VND: ${vnd}</p>
</form>
</body>
</html>
