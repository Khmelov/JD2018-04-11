<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Логин</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-3>email</div>
             <div class=col-md-2>Имя</div>

        </div>
    </div>

    <div class="container">
        <c:forEach items="${owner}" var="owner">
            <form class="update-user-${owner.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${owner.id}"/>
                    <div class=col-md-2>
                        <input id="Login" class="form-control input-md" name="Login"
                               value="${owner.login}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="Password" class="form-control input-md" name="Password"
                               value="${owner.pass}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="email" class="form-control input-md" name="email"
                               value="${owner.email}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="Name" class="form-control input-md" name="Name"
                               value="${owner.name}"/>
                    </div>


                    <button id="Delete" value="Delete" name="Delete" class=" btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>

        <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
           Обновить
         </button>
    </div>

</div>
</body>

