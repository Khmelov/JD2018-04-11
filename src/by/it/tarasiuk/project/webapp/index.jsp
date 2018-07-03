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
            <th scope="col">Брэнд</th>
            <th scope="col">Модель</th>
            <th scope="col">Год выпуска</th>
            <th scope="col">Тип велосипеда</th>
            <th scope="col">Класс велосипеда</th>
            <th scope="col">Цвет</th>
            <th scope="col">Цена</th>
            <th scope="col">Описание</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="advert" items="${adverts}">
            <tr>
                <td>${advert.brand}</td>
                <td>${advert.model}</td>
                <td>${advert.year}</td>
                <td>${advert.type}</td>
                <td>${advert.grade}</td>
                <td>${advert.color}</td>
                <td>${advert.price}</td>
                <td>${advert.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
