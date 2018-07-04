<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=SignUp">
    <fieldset>

    <!-- Form Name -->
    <legend>Форма регистрации</legend>

    <!-- Login input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="textinput">Логин</label>
      <div class="col-md-4">
      <input id="login" name="login" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Email input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="email">Email</label>
      <div class="col-md-4">
      <input id="email" name="email" type="text" placeholder="yourmail@mailbox.address" class="form-control input-md" required="">
      <span class="help-block">${help_email}</span>
      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Пароль</label>
      <div class="col-md-4">
        <input id="password" name="password" type="password" placeholder="password" class="form-control input-md" required="">
        <span class="help-block">${help_password}</span>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="submit">Регистрация</label>
      <div class="col-md-4">
        <button id="submit" name="submit" class="btn btn-success">Регистрация</button>
      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>




