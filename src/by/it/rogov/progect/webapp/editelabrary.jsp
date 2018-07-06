<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <c:choose>
        <c:when test="${edit==1}">
            <form class="form-horizontal" method="post" action="do?command=EditeLabrary">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Создание статьи</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textFree">Заглавие</label>
                        <div class="col-md-4">
                            <input id="textFree" name="textFree" type="text" placeholder=""
                                   class="form-control input-md" value="${labrary.textFree}">
                            <span class="help-block">${help_login}</span>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textPay">Содержание</label>
                        <div class="col-md-12">
                    <textarea rows="5" id="textPay" name="textPay" type="text" placeholder=""
                              class="form-control input-md" >${labrary.textPay}</textarea>

                            <span class="help-block">${help_password}</span>
                        </div>
                    </div>

                    <button id="update" value="1" name="update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="delete" value="1" name="delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                    <button id="back" value="1" name="back" class="btn btn-danger col-md-1">
                        Назад
                    </button>
            </form>
        </c:when>
        <c:otherwise>
            <p>Содержание </p>
            <form class="form-horizontal" method="post" action="do?command=EditeLabrary">
                <div class=col-md-4>
                    <div class="list-group">
                        <c:forEach items="${textFrees}" var="textFree">
                            <button class="btn btn-success-action" name="read"
                                    id="read" value="${textFree.id}">
                                ${textFree.textFree}
                            </button>
                        </c:forEach>
                    </div>
                </div>
            </form>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
