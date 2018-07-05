<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateAD" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Добавить товар</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="description">Описание</label>
              <div class="col-md-4">
              <input value="description" id="description" name="description" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="price">Цена</label>
              <div class="col-md-4">
              <input value="12" id="price" name="price" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="size">Размер</label>
              <div class="col-md-4">
              <input value="M" id="size" name="size" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="fabric">Тип ткани</label>
              <div class="col-md-4">
              <input value="fabric" id="fabric" name="fabric" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="colour">Цвет</label>
              <div class="col-md-4">
              <input value="colour" id="colour" name="colour" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="sex">Пол</label>
              <div class="col-md-4">
              <input value="sex" id="sex" name="sex" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="producer">Изготовитель</label>
              <div class="col-md-4">
              <input value="producer" id="producer" name="producer" type="text" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="submit">Создать объявление</label>
              <div class="col-md-4">
                <button id="submit" name="submit" class="btn btn-primary">submit</button>
              </div>
            </div>

            </fieldset>
            </form>
</div>
</body>
</html>
