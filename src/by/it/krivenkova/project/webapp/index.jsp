<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
     <table class="table">
            <thead>
            <tr>
                <th scope="col">Город отправления</th>
                <th scope="col">Дата отправления</th>
                <th scope="col">Время отпраления</th>
                <th scope="col">Город прибытия</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество билетов</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="route" items="${routes}">
                <tr>
                    <td>${route.depTown}</td>
                    <td>${route.depDate}</td>
                    <td>${route.depTime}</td>
                    <td>${route.arrTown}</td>
                    <td>${route.price}</td>
                    <td>${route.numTickets}</td>
                </tr>
            </c:forEach>

  </tbody>
    </table>
</div>
</body>
</html>
