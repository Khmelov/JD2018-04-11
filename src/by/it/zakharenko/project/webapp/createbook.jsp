<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>User: ${user}</p>
    <form class="form-horizontal" method="post" action="do?command=CreateBook">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Description</label>
                <div class="col-md-4">
                    <input id="description" name="description" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="author">Author</label>
                <div class="col-md-4">
                    <input id="author" name="author" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="genre">Genre</label>
                <div class="col-md-4">
                    <input id="genre" name="genre" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="pages">Pages</label>
                <div class="col-md-4">
                    <input id="pages" name="pages" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createbook">Create book</label>
                <div class="col-md-4">
                    <button id="createbook" name="createbook" class="btn btn-success">Create book</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>