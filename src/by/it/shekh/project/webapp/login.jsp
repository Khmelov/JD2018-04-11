<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>User: ${user}</p>

    <form class="form-horizontal" method="post" action="do?command=Login">
        <fieldset>

        <!-- Form Name -->
        <legend>Login form</legend>

        <!-- Login input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="textinput">Login</label>
          <div class="col-md-4">
          <input id="login" name="login" type="text" placeholder="" class="form-control input-md">
          <span class="help-block">${help_login}</span>
          </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="password">Password</label>
          <div class="col-md-4">
            <input id="password" name="password" type="password" placeholder="password" class="form-control input-md" required="">
            <span class="help-block">${help_password}</span>
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="submit">Sign up</label>
          <div class="col-md-4">
            <button id="submit" name="submit" class="btn btn-primary">Sign up</button>
          </div>
        </div>

        </fieldset>
        </form>


</div>
</body>
</html>

