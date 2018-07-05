<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateCar" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание объявления</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Модель</label>
                <div class="col-md-4">
                    <input value="model" id="model" name="model" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year">Год выпуска</label>
                <div class="col-md-4">
                    <input value="1965" id="year" name="year" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

             <div class="form-group">
                            <label class="col-md-4 control-label" for="color">Цвет</label>
                            <div class="col-md-4">
                                <input value="color" id="color" name="color" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="vengine">Объем двигателя</label>
                <div class="col-md-4">
                    <input value="5.0" id="vengine" name="vengine" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="60000" id="price" name="price" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Создать объявление</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Добавить</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
