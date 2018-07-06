<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateGood" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание товара</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="idgood">Артикул товара</label>
                <div class="col-md-4">
                    <input value="12345" id="idgood" name="idgood" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="goodname">Наименование</label>
                <div class="col-md-4">
                    <input value="Wild River Escape" id="goodname" name="goodname" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <input value="Hop in the police speedboat and go after the crook! Steer around the rocks and logs in the river as you get closer to the raft. Turn on the bubble lights and pull up next to the raft. Watch out for the skunk passenger, you don’t want to get sprayed! Phew!" id="description" name="description" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input-->
            <label class="col-md-4 control-label" for="piecies">Количество деталей</label>
                     <div class="col-md-4">
                      <input value="2" id="piecies" name="piecies" type="text" placeholder="" class="form-control input-md">
                       </div>
                      <div class="form-group">
             </div>

             <!-- Text input-->
              <div class="form-group">
              <label class="col-md-4 control-label" for="price">Цена</label>
              <div class="col-md-4">
              <input value="2" id="price" name="price" type="text" placeholder="" class="form-control input-md">
               </div>
              </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Создать товар</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Создать</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>


    <div class="container">
        <div class="row">
            <div class=col-md-2>Артикул</div>
            <div class=col-md-2>Наименование</div>
            <div class=col-md-2>Описание</div>
            <div class=col-md-2>Количество деталей</div>
            <div class=col-md-1>Цена</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${goods}" var="good">
            <form class="update-good-${good.id}" action="do?command=EditGood" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${good.id}"/>
                    <div class=col-md-2>
                        <input id="idgood" class="form-control input-md" name="idgood"
                               value="${good.idgood}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="goodname" class="form-control input-md" name="goodname"
                               value="${good.goodname}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="description" class="form-control input-md" name="description"
                               value="${good.description}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="piecies" class="form-control input-md" name="piecies"
                               value="${good.piecies}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${good.price}"/>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>
</body>
</html>
