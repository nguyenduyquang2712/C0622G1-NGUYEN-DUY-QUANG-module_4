<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="setting" action="/save" method="post">

    <pre>ID          :<form:input readonly="true" cssStyle="border: 0px" path="id"/></pre>
    <pre>Languages   :<form:select path="languages" items="${languagesList}"/> </pre>
    <pre>Page size   :Show <form:select path="pageSize" items="${pageSizeList}"/> </pre>
    <pre>Spam Filter :<form:checkbox path="spamsFilter"/> Enable spams filter </pre>
    <pre>Signature   :<form:textarea path="signature"/></pre>
    <pre><button type="submit">Update</button> <a href="/">Cancel</a></pre>

</form:form>


</body>
</html>