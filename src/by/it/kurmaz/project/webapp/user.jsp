<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
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
          </div>
        </div>
    </div>
</body>
</html>
