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
             <th scope="col">Модель</th>
             <th scope="col">Год выпуска</th>
             <th scope="col">Цвет</th>
             <th scope="col">Объем двигателя</th>
             <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cars" items="${cars}">
            <tr>
                <td>${cars.model}</td>
                <td>${cars.year}</td>
                <td>${cars.color}</td>
                <td>${cars.vengine}</td>
                <td>${cars.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
