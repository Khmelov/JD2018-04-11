<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">
     <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

        <!-- Form Name -->
        <legend>Выход</legend>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="logout"></label>
          <div class="col-md-4">
            <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
          </div>
        </div>

        </fieldset>
        </form>
</div>
</body>
</html>


