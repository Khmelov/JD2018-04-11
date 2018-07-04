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
            <th scope="col">Название</th>
            <th scope="col">Автор</th>
            <th scope="col">Жанр</th>
            <th scope="col">Количество страниц</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.description}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.pages}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
