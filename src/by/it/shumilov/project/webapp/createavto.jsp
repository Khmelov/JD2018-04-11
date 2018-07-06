<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>

<body>
<%@ include file="include/menu.htm" %>
<div class="container">


    <div class="container">
        <div class="row">
            <div class=col-md-1>Mark</div>
            <div class=col-md-1>Model</div>
            <div class=col-md-1>Color</div>
            <div class=col-md-3>Number VIN</div>
            <div class=col-md-1>Year</div>
            <div class=col-md-2>Gos Number</div>
            <div class=col-md-1>Rate</div>

        </div>
    </div>

    <div class="container">
        <c:forEach items="${avtos}" var="avto">
            <form class="update-avto-${avto.id}" action="do?command=CreateAvto" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${avto.id}"/>
                    <div class=col-md-1>
                        <input id="mark" class="form-control input-md" name="mark"
                               value="${avto.mark}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="model" class="form-control input-md" name="model"
                               value="${avto.model}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="color" class="form-control input-md" name="color"
                               value="${avto.color}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="nvin" class="form-control input-md" name="nvin"
                               value="${avto.nvin}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="year" class="form-control input-md" name="year"
                               value="${avto.year}"/>
                    </div>                    
                    <div class=col-md-2>
                        <input id="ngos" class="form-control input-md" name="ngos"
                               value="${avto.ngos}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="rate" class="form-control input-md" name="rate"
                               value="${avto.rate}"/>
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

</div>

<div class="container">

    <form class="form-horizontal" method="post" action="do?command=CreateAvto">
    <fieldset>

    <!-- Form Name -->
    <legend>Login </legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="mark">Mark</label>
      <div class="col-md-4">
      <input id="mark" name="mark" type="text" placeholder="" value="KIA" class="form-control input-md">
      <span class="help-block">${help_mark}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="model">Model</label>
      <div class="col-md-4">
      <input id="model" name="model" type="text" placeholder="" value="RIO" class="form-control input-md">
      <span class="help-block">${help_model}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="color">Color</label>
      <div class="col-md-4">
      <input id="color" name="color" type="text" placeholder="" value="Black"  class="form-control input-md">
      <span class="help-block">${help_color}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="nvin">Number VIN</label>
      <div class="col-md-4">
      <input id="nvin" name="nvin" type="text" placeholder="" value="1A2S3D4F5G6H7J8K9" class="form-control input-md">
      <span class="help-block">${help_nvin}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="year">Year</label>
      <div class="col-md-4">
      <input id="year" name="year" type="text" placeholder="" value="2010" class="form-control input-md">
      <span class="help-block">${help_year}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="ngos">Gos Number</label>
      <div class="col-md-4">
      <input id="ngos" name="ngos" type="text" placeholder="" value="4321 AS-7" class="form-control input-md">
      <span class="help-block">${help_ngos}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="rate">Rate</label>
      <div class="col-md-4">
      <input id="rate" name="rate" type="text" placeholder="" value="234.5" class="form-control input-md">
      <span class="help-block">${help_rate}</span>
      </div>
    </div>


    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Add"></label>
      <div class="col-md-4">
        <button id="Add" name="Add" class="btn btn-success">SignUp</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>