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
                <th scope="col">Тип тура</th>
                <th scope="col">Место назначения</th>
                <th scope="col">Отель</th>
                <th scope="col">Уровень отеля</th>
                <th scope="col">Количество ночей</th>
                <th scope="col">Стоимость</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="travelOffers" items="${travelOffers}">
                <tr>
                    <td>${travelOffers.description}</td>
                    <td>${travelOffers.typeOfTravel}</td>
                    <td>${travelOffers.destination}</td>
                    <td>${travelOffers.hotel}</td>
                    <td>${travelOffers.levelOfAccommodation}</td>
                    <td>${travelOffers.numberOfNights}</td>
                    <td>${travelOffers.price}</td>
                </tr>
            </c:forEach>


            </tbody>
    </table>

</div>
</body>
</html>
