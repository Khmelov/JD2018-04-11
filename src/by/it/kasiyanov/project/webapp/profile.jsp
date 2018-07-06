<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
     <!-- <p>Пользователь: ${user}</p> -->

    <h2>Данные профиля</h2>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

        <!-- Form Name -->
        <legend>Изменить персональные данные</legend>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="login">Логин</label>
          <div class="col-md-4">
          <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
           value="${user.login}">
          <span class="help-block">Enter new login</span>
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="email">Почта</label>
          <div class="col-md-4">
          <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
          value="${user.email}">
          <span class="help-block">Enter new email</span>
          </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="password">Пароль</label>
          <div class="col-md-4">
            <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
            value="${user.password}">
            <span class="help-block">Enter new password</span>
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="update"></label>
          <div class="col-md-4">
            <button id="update" name="update" class="btn btn-primary">Обновить</button>
          </div>
        </div>

        </fieldset>
        </form>


    <h2>Мои объявления</h2>
            <table class="table">
                 <thead>
                 <tr>
                     <th scope="col">Описание</th>
                     <th scope="col">Тип тура</th>
                     <th scope="col">Место назначения</th>
                     <th scope="col">Отель</th>
                     <th scope="col">Уровень отеля</th>
                     <th scope="col">Количество ночей</th>
                     <th scope="col">Стоимость</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach var="travelOffers" items="${travelOffers}">
                     <tr>
                         <td>${travelOffers.description}</td>
                         <td>${travelOffers.typeOfTravel}</td>
                         <td>${travelOffers.destination}</td>
                         <td>${travelOffers.hotel}</td>
                         <td>${travelOffers.levelOfAccommodation}</td>
                         <td>${travelOffers.numberOfNights}</td>
                         <td>${travelOffers.price}</td>
                     </tr>
                 </c:forEach>


                 </tbody>
            </table>


    <form class="form-horizontal" method="post" action="do?command=Profile">
          <fieldset>

                <!-- Form Name -->
                <legend>Выход</legend>

                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="submit"></label>
                  <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                  </div>
                </div>

          </fieldset>
    </form>
</div>
</body>
</html>
