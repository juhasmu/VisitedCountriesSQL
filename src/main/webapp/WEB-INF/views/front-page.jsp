<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<div class="jumbotron text-center">
<head>
<title>Country List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<a href="${pageContext.request.contextPath}/second-page">Database</a>
<form:form method="POST" action="saveCountry" modelAttribute="visitedCountry">
    Country: <form:input path="name"/><br/>
    Year visited: <form:input path="year"/><br/>
    <input type="submit" value="save"/>
</form:form>
</div>
<br/>
<br/>
<br/>
<div class="container">
  <div class="row">
  <div class="col-sm-4">
     <h3>Asian Countries</h3>
     <table>
        <c:set var = "count_asia" value = "${0}"/>
        <c:forEach items = "${countries}" var = "listElement">
            <c:if test = "${listElement.continent.equals('asia')}">
                <c:set var = "count_asia" value = "${count_asia+1}"/>
                <tr><td>
                <c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                <c:out value = "${listElement.name}"/>
                </td>
                <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                </tr><c:if test = "${listElement.id==newist}"></p></c:if>
            </c:if>
        </c:forEach>
        <c:out value="${count_asia}"/> Countries visited in Asia
    </table>
   </div>
<br/>
<br/>
<br/>
    <div class="col-sm-4">
        <h3>African Countries</h3>
        <table>
            <c:set var = "count_africa" value = "${0}"/>
            <c:forEach items = "${countries}" var = "listElement">
                <c:if test = "${listElement.continent.equals('africa')}">
                    <c:set var = "count_africa" value = "${count_africa+1}"/>
                    <c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                    <tr><td>
                    <c:out value = "${listElement.name}"/>
                    </td>
                    <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                    </tr><c:if test = "${listElement.id==newist}"></p></c:if>
                </c:if>
            </c:forEach>
            <c:out value="${count_africa}"/> Countries visited in Africa
        </table>
    </div>
<br/>
<br/>
<br/>
    <div class="col-sm-4">
        <h3>European Countries</h3>
        <table>
            <c:set var = "count_europa" value = "${0}"/>
            <c:forEach items = "${countries}" var = "listElement">
                <c:if test = "${listElement.continent.equals('europa')}">
                    <c:set var = "count_europa" value = "${count_europa+1}"/>
                    <tr><td><c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                    <c:out value = "${listElement.name}"/>
                    </td>
                    <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                    </tr><c:if test = "${listElement.id==newist}"></p></c:if>
                </c:if>
            </c:forEach>
            <c:out value="${count_europa}"/> Countries visited in Europa
        </table>
     </div>
<br/>
<br/>
<br/>
    <div class="col-sm-4">
        <h3>North American Countries</h3>
        <table>
            <c:set var = "count_na" value = "${0}"/>
            <c:forEach items = "${countries}" var = "listElement">
                <c:if test = "${listElement.continent.equals('north_america')}">
                    <c:set var = "count_na" value = "${count_na+1}"/>
                    <tr><td><c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                    <c:out value = "${listElement.name}"/>
                    </td>
                    <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                    </tr><c:if test = "${listElement.id==newist}"></p></c:if>
                </c:if>
            </c:forEach>
            <c:out value="${count_na}"/> Countries visited in North America
        </table>
    </div>
<br/>
<br/>
<br/>
    <div class="col-sm-4">
        <h3>South American Countries</h3>
        <table>
            <c:set var = "count_sa" value = "${0}"/>
            <c:forEach items = "${countries}" var = "listElement">
                <c:if test = "${listElement.continent.equals('south_america')}">
                    <c:set var = "count_sa" value = "${count_sa+1}"/>
                    <tr><td><c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                    <c:out value = "${listElement.name}"/>
                    </td>
                    <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                    </tr><c:if test = "${listElement.id==newist}"></p></c:if>
                </c:if>
            </c:forEach>
            <c:out value="${count_sa}"/> Countries visited in South America
        </table>
    </div>
<br/>
<br/>
<br/>
    <div class="col-sm-4">
        <h3>Oceanian Countries</h3>
        <table>
            <c:set var = "count_oceania" value = "${0}"/>
            <c:forEach items = "${countries}" var = "listElement">
                <c:if test = "${listElement.continent.equals('oceania')}">
                    <c:set var = "count_oceania" value = "${count_oceania+1}"/>
                    <tr><td><c:if test = "${listElement.id==newist}"><p style="color:Tomato;"></c:if>
                    <c:out value = "${listElement.name}"/>
                    </td><c:if test = "${listElement.id==newist}"></p></c:if>
                    <td>|<c:forEach items = "${listElement.years}" var = "year"><c:out value = "${year.year}"/>|</c:forEach></td>
                    </tr>
                </c:if>
            </c:forEach>
            <c:out value="${count_oceania}"/> Countries visited in Oceania
        </table>
    </div>
<br/>
<br/>
</div>
</div>
<div class="jumbotron text-center">
<h1>You have visited <c:out value="${count_oceania+count_sa+count_na+count_europa+count_africa+count_asia}"/> Countries in World</h1>
<br/>
<br/>
<br/>
<form:form method="POST" action="saveCountry" modelAttribute="visitedCountry">
    Country: <form:input path="name"/><br/>
    Year visited: <form:input path="year"/><br/>
    <input type="submit" value="save"/>
</form:form>
</div>
</body>
</html>