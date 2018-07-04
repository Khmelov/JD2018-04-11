<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateFacade" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание нового фасада</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Название</label>
                <div class="col-md-4">
                    <input value="name" id="name" name="name" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flat">Описание</label>
                <div class="col-md-4">
                    <input value="description" id="description" name="description" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flats">Размеры</label>
                <div class="col-md-4">
                    <input value="1x1 m2" id="dimensions" name="dimensions" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="130" id="price" name="price" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="area">Дополнительные сведения</label>
                <div class="col-md-4">
                    <input value="44" id="facade_specs" name="facade_specs" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Добавить фасад</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Button</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
