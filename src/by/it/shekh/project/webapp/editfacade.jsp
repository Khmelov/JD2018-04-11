<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Название</div>
            <div class=col-md-2>Описание</div>
            <div class=col-md-2>Размеры</div>
            <div class=col-md-2>Цена, BYN</div>
            <div class=col-md-2>Доп. сведения</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${facades}" var="facade">
            <form class="update-facade-${facade.id_facade}" action="do?command=EditFacade" method=POST>
                <div class="row">
                    <input name="id" value="${facade.id_facade}"/>
                    <div class=col-md-2>
                        <input id="facade_name" class="form-control input-md" name="name"
                               value="${facade.facade_name}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="facade_description" class="form-control input-md" name="description"
                               value="${facade.facade_description}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="facade_dimensions" class="form-control input-md" name="dimensions"
                               value="${facade.facade_dimensions}"/>
                    </div>
                    <div class=col-md-2>
                         <input id="facade_price" class="form-control input-md" name="price"
                         value="${facade.facade_price}"/>
                    </div>
                     <div class=col-md-2>
                         <input id="facade_specs" class="form-control input-md" name="facade_specs"
                         value="${facade.facade_specs}"/>
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