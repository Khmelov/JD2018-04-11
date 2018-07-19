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
                <label class="col-md-4 control-label" for="numgood">Количество товара</label>
                <div class="col-md-4">
                    <input value="2" id="numgood" name="numgood" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="goods_id">goods_id</label>
                            <div class="col-md-4">
                                <input value="2" id="goods_id" name="goods_id" type="text" placeholder="" class="form-control input-md">
                            </div>
                        </div>


 <!--     <select id="goods_id" name="goods_id" class="form-control">
                            <c:forEach items="${goods}" var="goods">
                                <option value="${goods.id}" goods=${goods.id} }>
                                        ${goods.id}
                                </option>
                            </c:forEach>
      </select>
-->

            <!-- Text input-->

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
        <div class="row">
            <div class=col-md-2>Номер заказа</div>
            <div class=col-md-2>Количество товара</div>
            <div class=col-md-2>users_id</div>
            <div class=col-md-2>goods_id</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${orders}" var="order">
            <form class="update-order-${order.id}" action="do?command=EditOrder" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${order.id}"/>
                    <div class=col-md-2>
                        <input id="ord_id" class="form-control input-md" name="ord_id"
                               value="${order.ord_id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="numgood" class="form-control input-md" name="numgood"
                               value="${order.numgood}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="users_id" class="form-control input-md" name="users_id"
                               value="${order.users_id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="goods_id" class="form-control input-md" name="goods_id"
                               value="${order.goods_id}"/>
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
