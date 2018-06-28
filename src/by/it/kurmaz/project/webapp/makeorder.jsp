<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=makeorder">
<fieldset>

<!-- Form Name -->
<legend>Order</legend>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="select">Choose goods</label>
  <div class="col-md-4">
    <select id="select" name="select" class="form-control" multiple="multiple">
      <option value="vodka">Vodka</option>
      <option value="whiskey">Whiskey</option>
      <option value="cognac">Cognac</option>
      <option value="tequila">Tequila</option>
      <option value="baileys">Baileys</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Amount</label>
  <div class="col-md-4">
  <input id="amount" name="amount" type="text" placeholder="enter amount here" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Make Order</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Press</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>


