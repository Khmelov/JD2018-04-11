<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Имя</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-2>Роль</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${user.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="login" class="form-control input-md" name="Login"
                               value="${user.login}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="Password"
                               value="${user.password}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="email" class="form-control input-md" name="Email"
                               value="${user.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="role" name="fk_roles" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.fk_roles?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
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

