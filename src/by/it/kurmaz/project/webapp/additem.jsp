<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal"  method="post" action="do?command=addcatalogitem">
<fieldset>

<!-- Form Name -->
<legend>Adding Item to Catalog</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Booze name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="enter name" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Amount to store</label>
  <div class="col-md-4">
  <input id="amount" name="amount" type="text" placeholder="enter amount" class="form-control input-md">
  <span class="help-block">Integer only!</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="enter price" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Add</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Press</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>


