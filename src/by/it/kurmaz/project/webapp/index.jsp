<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<h1 align = "center">Welcome!<span class="badge badge-secondary">Under Construction</span></h1>
<div class="container">
    <form class="form-horizontal"  method="post" action="do?command=index">
    <fieldset>

    <!-- Form Name -->
    <legend>Select Profile Type</legend>

    <!-- Select Basic -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="select">Select Profile Type</label>
      <div class="col-md-4">
        <select id="select" name="select" class="form-control">
          <option value="admin">Admin</option>
          <option value="user">User</option>
        </select>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton">Select</label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Press here</button>
      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>
