<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateRoute" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание маршрута</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="depTown">Пункт отправления</label>
                <div class="col-md-4">
                    <input value="depTown" id="depTown" name="depTown" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flat">Дата отправления</label>
                <div class="col-md-4">
                    <input value="14.08" id="depDate" name="depDate" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="depTime">Время отпраления</label>
                <div class="col-md-4">
                    <input value="16:00" id="depTime" name="depTime" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="arrTown">Пункт прибытия</label>
                <div class="col-md-4">
                    <input value="arrTown" id="arrTown" name="arrTown" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="55555" id="price" name="price" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="numTickets">Количество билетов</label>
                <div class="col-md-4">
                    <input value="1" id="numTickets" name="numTickets" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

                 <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Создать объявление</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Button</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
