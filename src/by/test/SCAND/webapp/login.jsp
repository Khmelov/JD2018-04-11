<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">

    <form class="form-horizontal" method="post" actions="do?command=Login">
    <fieldset>

    <legend>Вход</legend>

    <div clsaa = "form-group">
        <label class="col-md-4 control-label" for="name">Имя</label>
        <div class="col-md-4">
           <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                  value="Admin">
           <span class="help-block">${help_login}</span>
             </div>
           </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Телефон</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="phone" placeholder="" class="form-control input-md" required=""
                           value="Admin">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-success">Войти</button>
                </div>
            </div>

                </fieldset>
         </form>
</div>
</body>
</html>

