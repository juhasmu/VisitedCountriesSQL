<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>
<a href="${pageContext.request.contextPath}/second-page">Database</a>
<form:form method="POST" action="saveCountry" modelAttribute="visitedCountry">
    Country: <form:input path="name"/><br/>
    Year visited: <form:input path="year"/><br/>
    <input type="submit" value="save"/>
</form:form>
<br/>
<br/>
<br/>
<h3>Asian Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('asia')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
        </tr>
    </c:if>
</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>African Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
     <c:if test = "${listElement.continent.equals('africa')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
        </tr>
    </c:if>
</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>European Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('europa')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>North American Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('north_america')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>South American Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('south_america')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>Oceanian Countries</h3>
<table>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('oceania')}">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

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