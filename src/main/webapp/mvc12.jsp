<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="${startInt}" end="${endInt}" var="number" varStatus="status">
    ${number}<c:if test="${!status.last}">, </c:if>
</c:forEach>
</body>
</html>
