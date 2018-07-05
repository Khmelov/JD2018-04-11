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
            <th scope="col">Описание</th>
            <th scope="col">Цена</th>
            <th scope="col">Размер</th>
            <th scope="col">Ткань</th>
            <th scope="col">Цвет</th>
            <th scope="col">Пол</th>
            <th scope="col">Производитель</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ad" items="${ads}">
            <tr>
                <td>${ad.description}</td>
                <td>${ad.price}</td>
                <td>${ad.size}</td>
                <td>${ad.fabric}</td>
                <td>${ad.colour}</td>
                <td>${ad.sex}</td>
                <td>${ad.producer}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
