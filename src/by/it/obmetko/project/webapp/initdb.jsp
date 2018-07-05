
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<form class="form-horizontal"  action="do?command=InitDB" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Init DB</legend>

        <div class="alert alert-success" role="alert">
          <h4 class="alert-heading">${message}</h4>
        </div>


    </fieldset>
</form>


</div>
</body>
</html>