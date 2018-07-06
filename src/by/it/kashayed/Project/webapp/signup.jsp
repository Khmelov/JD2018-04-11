<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" method="post" action="do?command=SignUp">
        <fieldset>

            <legend>Регистрация</legend>

            <div class="form-group">
                <label class="col-md-4 control-label" for="Login">Login</label>
                <div class="col-md-4">
                    <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md"
                    value="testLogin">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                    value="testEmail@email.com">
                    <span class="help-block">${help_email}</span>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <input id="Password" name="Password" type="Password" placeholder="" class="form-control input-md" required=""
                    value="testPassword">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

            <div class="form-group">
                            <label class="col-md-4 control-label" for="Name">Имя</label>
                            <div class="col-md-4">
                                <input id="Name" name="Name" type="text" placeholder="" class="form-control input-md" required=""
                                value="testName">
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




