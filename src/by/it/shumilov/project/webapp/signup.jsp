<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" method="post" action="do?command=SignUp">
    <fieldset>

    <!-- Form Name -->
    <legend>Sign Up</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login">Login</label>
      <div class="col-md-4">
      <input id="login" name="login" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="email">Email</label>
      <div class="col-md-4">
      <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block">${help_email}</span>
      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Password</label>
      <div class="col-md-4">
        <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
        <span class="help-block">${help_password}</span>
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




