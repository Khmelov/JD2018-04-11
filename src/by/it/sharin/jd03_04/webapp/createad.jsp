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
                <label class="col-md-4 control-label" for="marka">Марка</label>
                <div class="col-md-4">
                    <input value="skoda" id="marka" name="marka" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="18000" id="price" name="price" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Модель</label>
                <div class="col-md-4">
                    <input value="rapid" id="model" name="model" type="text" placeholder="" class="form-control input-md">

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
