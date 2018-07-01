<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div class="container">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${user.login}</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class=" col-md-9 col-lg-9 ">
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>User Login</td>
                        <td>${user.login}</td>
                      </tr>
                      <tr>
                        <td>E-mail</td>
                        <td>${user.email}</td>
                      </tr>
                      <tr>
                        <td>Phone number</td>
                        <td>${user.phone}</td>
                      </tr>
                       <tr>
                        <td>User status</td>
                        <td>${user.carma}</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

            <div class="panel-body">
              <div class="row">
                <div class=" col-md-9 col-lg-9 ">
                  <table class="table table-adress-information">
                    <tbody>
                      <tr>
                        <td>Country</td>
                        <td>${address.country}</td>
                      </tr>
                      <tr>
                        <td>City</td>
                        <td>${address.city}</td>
                      </tr>
                      <tr>
                        <td>Street</td>
                        <td>${address.street}</td>
                      </tr>
                       <tr>
                        <td>Building</td>
                        <td>${address.building}</td>
                      </tr>
                      <tr>
                        <td>Apartment</td>
                        <td>${address.apt}</td>
                      </tr>
                      <tr>
                        <td>ZIP Code</td>
                        <td>${address.zip}</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
    </div>

    <form class="form-horizontal" method="post" action="do?command=profile">
        <fieldset>
        <div class="form-group">
          <label class="col-md-4 control-label" for="logout">Log Out</label>
          <div class="col-md-4">
            <button id="logout" name="logout" class="btn btn-primary">Press here</button>
          </div>
        </div>
        </fieldset>
        </form>

<form class="form-horizontal">
    <fieldset>

    <!-- Form Name -->
    <legend>Update</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login">Login</label>
      <div class="col-md-4">
      <input id="login" name="login" type="text" placeholder="enter login here" class="form-control input-md" value="${user.login}">
      <span class="help-block">${help_login}</span>
      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Password</label>
      <div class="col-md-4">
        <input id="password" name="password" type="password" placeholder="enter password here" class="form-control input-md" value="${user.password}">
        <span class="help-block">${help_password}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="E-mail">E-mail</label>
      <div class="col-md-4">
      <input id="E-mail" name="E-mail" type="text" placeholder="enter e-mail here" class="form-control input-md" value="${user.email}">
      <span class="help-block">${help_E-mail}</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="phone">Phone Number</label>
      <div class="col-md-4">
      <input id="phone" name="phone" type="text" placeholder="enter phone number here" class="form-control input-md" value="${user.phone}">
      <span class="help-block">+375.....</span>
      </div>
    </div>
    </fieldset>
    </form>

    <div class="form-group">
      <label class="col-md-4 control-label" for="update">Update</label>
      <div class="col-md-4">
        <button id="update" name="update" class="btn btn-primary">Press here</button>
      </div>
    </div>
    </fieldset>
    </form>

</body>
</html>
