<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <p>Owner: ${owner}</p>

    <form class="form-horizontal" method="post" action="do?command=Login">
        <fieldset>


            <legend>Login Form</legend>


            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           value="testLogin">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
                           value="testPassword">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-success">Sign up</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

