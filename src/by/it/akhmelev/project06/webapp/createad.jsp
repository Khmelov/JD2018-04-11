<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateAD" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание объявления</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <input value="description" id="description" name="description" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flat">Этаж</label>
                <div class="col-md-4">
                    <input value="2" id="flat" name="flat" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flats">Этажность</label>
                <div class="col-md-4">
                    <input value="5" id="flats" name="flats" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="rooms">Число комнат</label>
                <div class="col-md-4">
                    <input value="3" id="rooms" name="rooms" type="text" placeholder="" class="form-control input-md">

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
                <label class="col-md-4 control-label" for="area">Площадь</label>
                <div class="col-md-4">
                    <input value="44" id="area" name="area" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Адрес</label>
                <div class="col-md-4">
                    <input value="Minsk address" id="address" name="address" type="text" placeholder="" class="form-control input-md">

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
