<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Пользователь: ${user.roles_id}</p>
    <c:out value="${user.roles_id}" />
   <table class='table'>
    <thead>
    <tr>
        <th  scope="col">
            Марка
        </th>
        <th  scope="col">
            Модель
        </th>
        <th  scope="col">
            Цвет
        </th>
        <th scope="col">
            Год
        </th>
        <th scope="col">
            Гос номер
        </th>
        <th scope="col">
            Тариф
        </th>
     </tr>
    </thead>
    <tbody>
<c:forEach var="avto"
    items="${avtos}" >
    <tr>
        <td>
                ${avto.mark}
            </td>
            <td>
               ${avto.model}
            </td>
            <td>
                ${avto.color}
            </td>
            <td>
               ${avto.year}
            </td>
            <td>
                ${avto.ngos}
            </td>
            <td>
                ${avto.rate}
            </td>
    </tr>
    </c:forEach>

    </tbody>

    </table>

</div>
</body>
</html>
