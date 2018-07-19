<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
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
            <th scope="col">Этаж</th>
            <th scope="col">Этажность</th>
            <th scope="col">Число комнат</th>
            <th scope="col">Цена</th>
            <th scope="col">Площадь</th>
            <th scope="col">Адрес</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ad" items="${ads}">
            <tr>
                <td>${ad.description}</td>
                <td>${ad.flat}</td>
                <td>${ad.flats}</td>
                <td>${ad.rooms}</td>
                <td>${ad.price}</td>
                <td>${ad.area}</td>
                <td>${ad.address}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

    <mytag:paginator count="${count}" step="10" urlprefix="?start="/>

</div>
</body>
</html>
