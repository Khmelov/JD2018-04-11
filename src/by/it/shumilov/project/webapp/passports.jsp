<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>







<div class="container">

<%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Firstname</div>
            <div class=col-md-2>Lastname</div>
            <div class=col-md-3>Pasportid</div>
            <div class=col-md-2>Phone</div>


        </div>
    </div>

    <div class="container">
        <c:forEach items="${passports}" var="passport">
            <form class="update-passport-${passport.id}" action="do?command=Passports" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${passport.id}"/>
                    <div class=col-md-2>
                        <input id="firstname" class="form-control input-md" name="firstname"
                               value="${passport.firstname}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="lastname" class="form-control input-md" name="lastname"
                               value="${passport.lastname}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="pasportid" class="form-control input-md" name="pasportid"
                               value="${passport.pasportid}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="phone" class="form-control input-md" name="phone"
                               value="${passport.phone}"/>
                    </div>


                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>

        </c:forEach>
    </div>

</div>

<div class="container">
    
     
    <form class="form-horizontal" method="post" action="do?command=Passports">
    <fieldset>

    <!-- Form Name -->
    <legend>Добавить паспортные данные</legend>



    <!-- Text input-->
     <input type="hidden" name="passports_id" value="${passports_id}">


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="firstname">Фамилия</label>
      <div class="col-md-4">
      <input id="firstname" name="firstname" type="text" placeholder="" value="firstname" class="form-control input-md">
      <span class="help-block">${help_firstname}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="lastname">Имя</label>
      <div class="col-md-4">
      <input id="lastname" name="lastname" type="text" placeholder="" value="lastname" class="form-control input-md">
      <span class="help-block">${help_lastname}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="pasportid">Номер паспорта</label>
      <div class="col-md-4">
      <input id="pasportid" name="pasportid" type="text" placeholder="" value="123454435900987RB6" class="form-control input-md">
      <span class="help-block">${help_pasportid}</span>
      </div>
    </div>


    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="phone">Номер телефона</label>
      <div class="col-md-4">
      <input id="phone" name="phone" type="text" placeholder="" value="375291234567" class="form-control input-md">
      <span class="help-block">${help_phone}</span>
      </div>
    </div>



    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Add"></label>
      <div class="col-md-4">
        <button id="Add" name="Add" class="btn btn-success">Добавить</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>