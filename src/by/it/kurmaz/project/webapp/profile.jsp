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
                  <table class="table table-address-information">
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
</body>
</html>
