<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/17/2022
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Settings Mail Information</h1> <br/>
<p>${mess}</p> <br/>
<table class="table table-striped">
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>EDIT</th>
    </tr>

    <c:forEach items="${settings}" var="setting">
    <tr>
        <td>${setting.languages}</td>
        <td>${setting.pageSize}</td>
        <c:if test="${setting.spamsFilter}">
            <td>Yes</td>
        </c:if>
        <c:if test="${!setting.spamsFilter}">
            <td>No</td>
        </c:if>
        <td>${setting.signature}</td>

        <td><a href="/edit/${setting.id}" type="button" class="btn btn-primary btn-lg">EDIT</a></td>
        </c:forEach>
    </tr>

</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>