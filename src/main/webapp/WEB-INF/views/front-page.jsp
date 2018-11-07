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
<c:set var = "count_asia" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('asia')}">
        <c:set var = "count_asia" value = "${count_asia+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
        </tr>
    </c:if>
</c:forEach>
<c:out value="${count_asia}"/> Countries visited in Asia
</table>
<br/>
<br/>
<br/>
<h3>African Countries</h3>
<table>
<c:set var = "count_africa" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
     <c:if test = "${listElement.continent.equals('africa')}">
        <c:set var = "count_africa" value = "${count_africa+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
        </tr>
    </c:if>
</c:forEach>
<c:out value="${count_africa}"/> Countries visited in Africa
</table>
<br/>
<br/>
<br/>
<h3>European Countries</h3>
<table>
<c:set var = "count_europa" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('europa')}">
        <c:set var = "count_europa" value = "${count_europa+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
<c:out value="${count_europa}"/> Countries visited in Europa
</table>
<br/>
<br/>
<br/>
<h3>North American Countries</h3>
<table>
<c:set var = "count_na" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('north_america')}">
        <c:set var = "count_na" value = "${count_na+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
<c:out value="${count_na}"/> Countries visited in North America
</table>
<br/>
<br/>
<br/>
<h3>South American Countries</h3>
<table>
<c:set var = "count_sa" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('south_america')}">
        <c:set var = "count_sa" value = "${count_sa+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
<c:out value="${count_sa}"/> Countries visited in South America
</table>
<br/>
<br/>
<br/>
<h3>Oceanian Countries</h3>
<table>
<c:set var = "count_oceania" value = "${0}"/>
<c:forEach items = "${countries}" var = "listElement">
    <c:if test = "${listElement.continent.equals('oceania')}">
        <c:set var = "count_oceania" value = "${count_oceania+1}"/>
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        <td><c:out value = "${listElement.year}"/></td>
    </tr>
    </c:if>

</c:forEach>
<c:out value="${count_oceania}"/> Countries visited in Oceania
</table>
<br/>
<br/>
You have visited <c:out value="${count_oceania+count_sa+count_na+count_europa+count_africa+count_asia}"/> Countries visited in World
<br/>
<form:form method="POST" action="saveCountry" modelAttribute="visitedCountry">
    Country: <form:input path="name"/><br/>
    Year visited: <form:input path="year"/><br/>
    <input type="submit" value="save"/>
</form:form>
</body>
</html>