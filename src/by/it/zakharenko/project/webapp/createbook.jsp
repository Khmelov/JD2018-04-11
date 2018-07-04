<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=CreateBook">
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

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Название</label>
                <div class="col-md-4">
                    <input value="name" id="name" name="name" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="author">Автор</label>
                <div class="col-md-4">
                    <input value="author" id="author" name="author" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="genre">Жанр</label>
                <div class="col-md-4">
                    <input value="genre" id="genre" name="genre" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="pages">Количество страниц</label>
                <div class="col-md-4">
                    <input value="130" id="pages" name="pages" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input value="9" id="price" name="price" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Create book</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Create book</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>