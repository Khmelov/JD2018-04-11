<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
     <p>Order: ${order}</p>
    <form class="form-horizontal" method="post" action="do?command=CreateOrder">
    <fieldset>

    <!-- Form Name -->
    <legend>Арендовать авто</legend>



    <!-- Text input-->
     <input type="hidden" name="avtos_id" value="${avtos_id}">


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="startorder">Start order</label>
      <div class="col-md-4">
      <input id="startorder" name="startorder" type="date" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="tenancy">Продолжительность</label>
      <div class="col-md-4">
      <input id="tenancy" name="tenancy" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="cost">Стоимость</label>
      <div class="col-md-4">
      <input id="cost" name="cost" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="discont">Скидка</label>
      <div class="col-md-4">
      <input id="discont" name="discont" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="realcost">Итоговая стоимость</label>
      <div class="col-md-4">
      <input id="realcost" name="realcost" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>


<


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="firstname">Фамилия</label>
      <div class="col-md-4">
      <input id="firstname" name="firstname" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="lastname">Имя</label>
      <div class="col-md-4">
      <input id="lastname" name="lastname" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="passporsid">Номер паспорта</label>
      <div class="col-md-4">
      <input id="passporsid" name="passporsid" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="phone">Номер телефона</label>
      <div class="col-md-4">
      <input id="phone" name="phone" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>



    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="button"></label>
      <div class="col-md-4">
        <button id="submit" name="submit" class="btn btn-success">Подтвердть заказ</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>