<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>

<body>
<div class="container">
   <%@ include file="include/menu.htm" %>



 <h4>Заказ автомобиля: ${avto.mark} ${avto.model}, ${avto.year}, ${avto.ngos}</h4>




    <form class="form-horizontal" method="post" action="do?command=CreateOrders">
    <fieldset>

    <!-- Form Name -->
    <legend>Арендовать авто</legend>



    <!-- Text input-->

     <input type="hidden" name="avtos_id" value=${avto.id}>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="startorder">Start order</label>
      <div class="col-md-4">
      <input id="startorder" name="startorder" type="date" placeholder="" value="2018-07-06" class="form-control input-md">
      <span class="help-block">${help_startorder}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="tenancy">Продолжительность</label>
      <div class="col-md-4">
      <input id="tenancy" name="tenancy" type="text" placeholder="" value="10" class="form-control input-md">
      <span class="help-block">${help_tenancy}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="cost">Стоимость</label>
      <div class="col-md-4">
      <input id="cost" name="cost" type="text" placeholder="" value="123.4" class="form-control input-md">
      <span class="help-block">${help_cost}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="discount">Скидка, %</label>
      <div class="col-md-4">
      <input id="discount" name="discount" type="text" placeholder="" value="15" class="form-control input-md">
      <span class="help-block">${help_discount}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="realcost">Итоговая стоимость</label>
      <div class="col-md-4">
      <input id="realcost" name="realcost" type="text" placeholder="" value="115" class="form-control input-md">
      <span class="help-block">${help_realcost}</span>
      </div>
    </div>


      <select id="pasports_id" name="pasports_id" class="form-control">
                            <c:forEach items="${pass}" var="pas">
                                <option value="${pas.id}" pasport=${pas.id} }>
                                        ${pas.pasportid}
                                </option>
                            </c:forEach>
      </select>




    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Add"></label>
      <div class="col-md-4">
        <button id="Add" name="Add" class="btn btn-success">Сделать заказ</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>