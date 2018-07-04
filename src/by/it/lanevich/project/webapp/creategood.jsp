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
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Артикул</th>
            <th scope="col">Наименование</th>
            <th scope="col">Описание</th>
            <th scope="col">Количество деталей</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="good" items="${goods}">
            <tr>
                <td>${good.idgood}</td>
                <td>${good.goodname}</td>
                <td>${good.description}</td>
                <td>${good.piecies}</td>
                <td>${good.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
