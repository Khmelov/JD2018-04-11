<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<div class="container">
    <div class="container">
        <div class="row">
            <div class=col-md-2>Название</div>
            <div class=col-md-2>Описание</div>
            <div class=col-md-2>Цена</div>
            <div class=col-md-2>Фото</div>
        </div>
    </div>

    <div class="container">
            <c:forEach items="${goods}" var="goods">
                <form class="update-goods-${goods.idgoods}" action="do?command=EditAd" method=POST>
                    <div class="row">
                        <input name="idgoods" type="hidden" value="${goods.idgoods}"/>
                        <div class=col-md-2>
                            <input id="name" class="form-control input-md" name="name"
                                   value="${goods.name}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="description" class="form-control input-md" name="description"
                                   value="${goods.description}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="price" class="form-control input-md" name="price"
                                   value="${goods.price}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="photo" class="form-control input-md" name="photo"
                                   value="${goods.photo}"/>
                        </div>

                        <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                            Обновить
                        </button>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                            Удалить
                        </button>
                    </div>
                </form>
                <p></p>
            </c:forEach>
        </div>

</div>
</body>

</html>