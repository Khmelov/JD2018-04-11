<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.html" %>

    <form class="form-horizontal" method="post" action="do?command=CreatePublication">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="title">Title</label>
                <div class="col-md-6">
                    <input id="title" name="title" type="text" placeholder="Title" class="form-control input-md" required="" value="testTitle">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="number">Number</label>
                <div class="col-md-2">
                    <input id="number" name="number" type="text" placeholder="Number" class="form-control input-md" required="" value="2">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="date">Date</label>
                <div class="col-md-4">
                    <input id="date" name="date" type="text" placeholder="27.06.2018" class="form-control input-md" required="" value="29.06.2018">

                </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Description</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="description" name="description" value="testDesription"></textarea>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-2">
                    <input id="price" name="price" type="text" placeholder="Price" class="form-control input-md" value="10.5">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createpublication"></label>
                <div class="col-md-4">
                    <button id="createpublication" name="createpublication" class="btn btn-success">Create</button>
                </div>
            </div>

        </fieldset>
    </form>



</div>
</body>
</html>

