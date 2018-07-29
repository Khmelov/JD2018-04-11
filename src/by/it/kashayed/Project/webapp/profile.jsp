<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <!-- <p>Пользователь: ${owner}</p> -->
    <h2>Данные профиля</h2>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Login">Login</label>
                <div class="col-md-4">
                    <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md"
                           value="${owner.login}">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                           value="${owner.email}">
                    <span class="help-block">${help_email}</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <input id="Password" name="Password" type="Password" placeholder="" class="form-control input-md" required=""
                           value="${owner.pass}">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="Name">Пароль</label>
                            <div class="col-md-4">
                                <input id="Name" name="Name" type="Name" placeholder="" class="form-control input-md" required=""
                                       value="${owner.name}">
                                <span class="help-block">${help_password}</span>
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


    <h2>Мои объявления</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Модель</th>
            <th scope="col">Год выпуска</th>
            <th scope="col">Цвет</th>
            <th scope="col">Объем двигателя</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cars" items="${cars}">
            <tr>
                <td>${cars.model}</td>
                <td>${cars.year}</td>
                <td>${cars.color}</td>
                <td>${cars.vengine}</td>
                <td>${cars.price}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


    <form class="form-horizontal" method="post" action="do?command=profile">
        <fieldset>

            <legend>Выход</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>
    <form class="form-horizontal" method="post" action="do?command=profile">
            <fieldset>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="logout"></label>
                    <div class="col-md-8">
                        <button id="deleteprofile" name="deleteprofile" value="3" class="btn btn-danger col-md-3"> Удалить профиль</button>
                    </div>
                </div>
            </fieldset>
        </form>


</div>
</body>
</html>
