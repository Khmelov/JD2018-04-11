<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.html" %>

    <div class="container">
        <div class="row">
            <div class=col-md-3>Описание</div>
            <div class=col-md-1>Номер публикации</div>
            <div class=col-md-1>Дата публикации</div>
            <div class=col-md-3>Содержание</div>
            <div class=col-md-1>Цена</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${publications}" var="publication">
            <form class="set-publications-${publication.id}" action="do?command=EditPublication" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${publication.id}"/>
                    <div class=col-md-3>
                        <textarea class="form-control" id="title" name="title">${publication.title}</textarea>
                    </div>
                    <div class=col-md-1>
                        <input id="number" class="form-control input-md" name="number"
                               value="${publication.number}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="date" class="form-control input-md" name="date"
                               value="${publication.date}"/>
                    </div>
                    <div class=col-md-3>
                        <textarea class="form-control" id="description" name="description">${publication.description}</textarea>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${publication.price}"/>
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

