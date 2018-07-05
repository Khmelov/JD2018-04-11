<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Артикул</th>
            <th scope="col">Наименование</th>
            <th scope="col">Описание</th>
            <th scope="col">Количество деталей</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goods}" var="good">
            <tr>
                <td>${good.idgood}</td>
                <td>${good.goodname}</td>
                <td>${good.description}</td>
                <td>${good.piecies}</td>
                <td>${good.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
