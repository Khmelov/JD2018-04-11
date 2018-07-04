<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <!-- <p>Пользователь: ${user}</p>-->
    <h3>Данные профиля</h3>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           value="${user.login}">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
                           value="${user.password}">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="email" placeholder="" class="form-control input-md" required=""
                           value="${user.email}">
                    <span class="help-block">${help_email}</span>
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
    </form>

    <h3>Мои объявления</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Брэнд</th>
            <th scope="col">Модель</th>
            <th scope="col">Год выпуска</th>
            <th scope="col">Тип велосипеда</th>
            <th scope="col">Класс велосипеда</th>
            <th scope="col">Цвет</th>
            <th scope="col">Цена</th>
            <th scope="col">Описание</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="advert" items="${adverts}">
            <tr>
                <td>${advert.brand}</td>
                <td>${advert.model}</td>
                <td>${advert.year}</td>
                <td>${advert.type}</td>
                <td>${advert.grade}</td>
                <td>${advert.color}</td>
                <td>${advert.price}</td>
                <td>${advert.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3>Выход из учетной записи</h3>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
