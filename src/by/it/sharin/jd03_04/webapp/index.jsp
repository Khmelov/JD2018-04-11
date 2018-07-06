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
            <th scope="col">Марка</th>
            <th scope="col">Модель</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ad" items="${ads}">
            <tr>
                <td>${ad.marka}</td>
                <td>${ad.model}</td>
                <td>${ad.price}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>
</body>
</html>
