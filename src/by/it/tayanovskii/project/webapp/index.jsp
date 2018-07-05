<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.html" %>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Описание</th>
            <th scope="col">Номер публикации</th>
            <th scope="col">Дата</th>
            <th scope="col">Содержание</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="publication" items="${publications}">
            <tr>
                <td>${publication.title}</td>
                <td>${publication.number}</td>
                <td>${publication.date}</td>
                <td>${publication.description}</td>
                <td>${publication.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
