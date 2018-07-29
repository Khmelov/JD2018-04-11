<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">
    <div class="container">
        <div class="row">
            <div class=col-md-2>Имя</div>
            <div class=col-md-3>Адресс</div>
            <div class=col-md-2>Телефон</div>
            <div class=col-md-2>Роль</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${user}" var="user">
            <form class="update-user-${user.iduser}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <input name="iduser" type="hidden" value="${user.iduser}"/>
                    <div class=col-md-2>
                        <input id="name" class="form-control input-md" name="name"
                               value="${user.name}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="address" class="form-control input-md" name="address"
                               value="${user.address}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="phone" class="form-control input-md" name="phone"
                               value="${user.phone}"/>
                    </div>
                    <div class=col-md-2>
                        <select id="clients_idclients" name="clients_idclients" class="form-control">
                            <c:forEach items="${clients}" var="roles">
                                <option value="${roles.idclients}" roles=${roles.idclients} ${roles.idclients==user.clients_idclients?"selected":""}>
                                        ${roles.roles}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>
</body>

