<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" method="post" action="do?command=CreateText">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание статьи</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textFree">Заглавие</label>
                <div class="col-md-4">
                    <input id="textFree" name="textFree" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textPay">Содержание</label>
                <div class="col-md-12">
                    <textarea rows="5" id="textPay" name="textPay" type="text" placeholder="" class="form-control input-md" ></textarea>
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-success">Создать</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
