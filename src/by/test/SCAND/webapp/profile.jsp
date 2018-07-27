<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>
 <!-- Form Name -->

<legend>Список товаров</legend>
    <table class="table">
            <thead>
            <tr>
                <th scope="col">Название</th>
                <th scope="col">Описание</th>
                <th scope="col">Цена</th>
                <th scope="col">Фото</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="goods" items="${goods}">
                <tr>
                    <td>${goods.name}</td>
                    <td>${goods.description}</td>
                    <td>${goods.price}</td>
                    <td>${goods.photo}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
         <mytag:paginator count="${count}" step="5" urlprefix="?command=profile&start="/>
          <c:choose>
         <c:when test="${user.clients_idclients == '1'}">
        <div class="form-group">
            <label class="col-md-2 control-label" for="profile"></label>
            <div class="col-md-2">
                <button id="del" name="del" value="1" class="btn btn-primary">Редактировать товары</button>
            </div>

        </div>
         </c:when>
         </c:choose>
         <!--  -->
        <legend>Редактировать профиль</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Имя</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           value="${user.name}">
                    <span class="help-block">${help_name}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Адресс</label>
                <div class="col-md-4">
                    <input id="address" name="address" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.address}">
                    <span class="help-block">${help_address}</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Телфон</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="phone" placeholder="" class="form-control input-md" required=""
                           value="${user.phone}">
                    <span class="help-block">${help_phone}</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="update"></label>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                </div>
            </div>

        </fieldset>
        <form class="form-horizontal" method="post" action="do?command=Profile">
                <fieldset>


                    <legend>Выход</legend>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="logout"></label>
                        <div class="col-md-4">
                            <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                        </div>
                    </div>

                    <legend>Удалить профиль</legend>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="logout"></label>
                        <div class="col-md-4">
                            <button id="delete" name="delete" value="1" class="btn btn-danger">Удалить</button>
                        </div>
                    </div>
                </fieldset>
            </form>

</div>
</body>
</html>
