<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
     <p>Avto: ${avto}</p>
    <form class="form-horizontal" method="post" action="do?command=CreateAvto">
    <fieldset>

    <!-- Form Name -->
    <legend>Login </legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="mark">Mark</label>
      <div class="col-md-4">
      <input id="mark" name="mark" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="model">Model</label>
      <div class="col-md-4">
      <input id="model" name="model" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="color">Color</label>
      <div class="col-md-4">
      <input id="color" name="color" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="nvin">Number VIN</label>
      <div class="col-md-4">
      <input id="nvin" name="nvin" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="year">Year</label>
      <div class="col-md-4">
      <input id="year" name="year" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="ngos">Gos Number</label>
      <div class="col-md-4">
      <input id="ngos" name="ngos" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="rate">Rate</label>
      <div class="col-md-4">
      <input id="rate" name="rate" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>


    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="button"></label>
      <div class="col-md-4">
        <button id="submit" name="submit" class="btn btn-success">SignUp</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>