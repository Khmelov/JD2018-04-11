<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" method="post" action="do?command=Password">
    <fieldset>

    <!-- Form Name -->
    <legend>Reset password</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Old password</label>
      <div class="col-md-4">
      <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
      <span class="help-block">${help_password}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password1">New password</label>
      <div class="col-md-4">
      <input id="password1" name="password1" type="password" placeholder="" class="form-control input-md" required="">
      <span class="help-block">${help_password1}</span>
      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password2">Repeat new password</label>
      <div class="col-md-4">
        <input id="password2" name="password2" type="password" placeholder="" class="form-control input-md" required="">
        <span class="help-block">${help_password2}</span>
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
<br>
<br>
<h4>${newpass}</h4>
</div>
</body>
</html>




