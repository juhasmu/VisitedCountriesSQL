<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <tr><td>
    <c:out value = "${listElement.name}"/>
    </td>
    <td><c:out value = "${listElement.year}"/></td>
    </tr>

</c:forEach>
</table>
<br/>
<br/>
<br/>

<form:form method="POST" action="saveCountry" modelAttribute="visitedCountry">
    Country: <form:input path="name"/><br/>
    Year visited: <form:input path="year"/><br/>
    <input type="submit" value="save"/>
</form:form>
</body>
</html>