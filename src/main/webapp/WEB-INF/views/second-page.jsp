<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Front Page</a>
<br/>
<br/>
<br/>
<h3>Asian Countries</h3>
<table>
<c:forEach items = "${asia}" var = "listElement">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        </tr>
</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>African Countries</h3>
<table>
<c:forEach items = "${africa}" var = "listElement">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        </tr>
</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>European Countries</h3>
<table>
<c:forEach items = "${europa}" var = "listElement">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td>
        </tr>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>North American Countries</h3>
<table>
<c:forEach items = "${north_america}" var = "listElement">
     <tr><td>
     <c:out value = "${listElement.name}"/>
     </td>
     </tr>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>South American Countries</h3>
<table>
<c:forEach items = "${south_america}" var = "listElement">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td></tr>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<h3>Oceanian Countries</h3>
<table>
<c:forEach items = "${oceania}" var = "listElement">
        <tr><td>
        <c:out value = "${listElement.name}"/>
        </td></tr>

</c:forEach>
</table>
<br/>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/">Front Page</a>
</body>
</html>