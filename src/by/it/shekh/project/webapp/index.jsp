<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <table class="table">
            <thead>
            <tr>
                <th scope="col">Название</th>
                <th scope="col">Размеры</th>
                <th scope="col">Описание</th>
                <th scope="col">Цена</th>
                <th scope="col">Дополнительные сведения</th>
            </tr>
            </thead>
            <tbody>
                    <c:forEach var="facade" items="${facades}">
                        <tr>
                            <td>${facade.facade_name}</td>
                            <td>${facade.facade_dimensions}</td>
                            <td>${facade.facade_description}</td>
                            <td>${facade.facade_price}</td>
                            <td>${facade.facade_specs}</td>
                            <c:if test="${user.getId_roles()!=1 && user.getId_roles()!=null}">
                                    <td>Кнопка</td>
                            </c:if>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>

        <mytag:paginator count="${count}" step="5" urlprefix="?start="/>
</div>
</body>
</html>
