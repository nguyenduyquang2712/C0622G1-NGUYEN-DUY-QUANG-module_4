<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="result" method="get" >
    <h2>Simple Computer</h2>
    <input type="number" name="a" value="${a}" placeholder="input number">
    <input type="number" name="b" value="${b}" placeholder="input number"> <br><br>
    <button type="submit" value="add" name="submit">Addation(+)</button>
    <button type="submit" value="sub" name="submit">Subtraction(-)</button>
    <button type="submit" value="multiple" name="submit">Multiplication(*)</button>
    <button type="submit" value="division" name="submit">Division(/ )</button>
</form>
<p>Result : ${result}</p>
</body>
</html>