<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">

    <form class="form-horizontal" action="do?command=CreateAD" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание объявления</legend>


            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Название</label>
                <div class="col-md-4">
                    <input value="Название" id="name" name="name" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <input value="Описание" id="description" name="description" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="548.6" id="price" name="price" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <div class="form-group">
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Создать</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
