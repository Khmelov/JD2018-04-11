<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateOrder" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание заказа</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="ord_id">Номер заказа</label>
                <div class="col-md-4">
                    <input value="1" id="ord_id" name="ord_id" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="goods_id">Артикул товара</label>
                <div class="col-md-4">
                    <input value="411511" id="goods_id" name="goods_id" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="numgood">Количество товара</label>
                <div class="col-md-4">
                    <input value="2" id="numgood" name="numgood" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input-->
            <label class="col-md-4 control-label" for="totalprice">Цена</label>
                     <div class="col-md-4">
                      <input value="2" id="totalprice" name="totalprice" type="text" placeholder="" class="form-control input-md">
                       </div>
                      <div class="form-group">
             </div>

             <!-- Text input-->
              <div class="form-group">
              <label class="col-md-4 control-label" for="users_id">users_id</label>
              <div class="col-md-4">
              <input value="2" id="users_id" name="users_id" type="text" placeholder="" class="form-control input-md">
               </div>
              </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Создать заказ</label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Заказать</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<div class="container">
      <table class="table">
        <thead>
        <tr>
            <th scope="col">Номер заказа</th>
            <th scope="col">Артикул товара</th>
            <th scope="col">Количество товара</th>
            <th scope="col">Цена</th>
            <th scope="col">users_id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.ord_id}</td>
                <td>${order.goods_id}</td>
                <td>${order.numgood}</td>
                <td>${good.price}</td>
                <td>${order.users_id}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
