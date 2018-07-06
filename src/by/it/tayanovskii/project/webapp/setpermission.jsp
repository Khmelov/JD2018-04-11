<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.html" %>

    <div class="container">
        <div class="row">
            <div class=col-md-6>Публикация</div>
            <div class=col-md-3>Пользователь</div>
        </div>
    </div>


    <div class="container">
            <form class="set-publications-${publication.id}" action="do?command=SetPermission" method=POST>
                <div class="row">
                    <div class=col-md-6>
                        <select id="publications_id" name="publications_id" class="form-control">
                            <c:forEach items="${publications}" var="publication">
                                <option value="${publication.id}">
                                        ${publication.title} ${publication.date} ${publication.price}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class=col-md-3>
                        <select id="users_id" name="users_id" class="form-control">
                            <c:forEach items="${users}" var="user">
                                <option value="${user.id}">
                                        ${user.login}
                                </option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="col-md-2">
                        <button id="SetTrue" value="SetTrue" name="SetTrue" class="btn btn-success">
                            TRUE
                        </button>
                        <button id="SetFalse" name="SetFalse" class="btn btn-danger">FALSE</button>
                    </div>


                </div>
            </form>
            <p></p>
    </div>

</div>
</body>

