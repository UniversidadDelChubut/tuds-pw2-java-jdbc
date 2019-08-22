<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fichadas</title>
    </head>
    <body>
        <h1>Fichadas del día <fmt:formatDate pattern="dd/MM/yyyy" value="${hoy}"/></h1>

        <c:if test="${empty datos}">
            <p class="error">No hay datos disponibles.</p>
        </c:if>

        <c:if test="${not empty datos}">
            <c:forEach items="${datos}" var="item">
                <table><tr><th></th></tr></table>
            </c:forEach>
        </c:if>
    </body>
</html>