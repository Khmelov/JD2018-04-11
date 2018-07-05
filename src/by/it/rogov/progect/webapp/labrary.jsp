<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>


    <div class="container">
        <%@ include file="include/menu.htm" %>

 <c:choose>
  <c:when test="${test==1}">
  <form class="form-horizontal" method="post" action="do?command=Labrary">
            <div class="col-md-12">

            <legend>${labrary.textPay}</legend>

            </div>
            <fieldset>
               <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="back"></label>
                    <div class="col-md-4">
                        <button id="back" name="back" value="1" class="btn btn-success">Назад</button>
                    </div>
                </div>

            </fieldset>
        </form>

   </c:when>


 <c:otherwise>
  <form class="form-horizontal" method="post" action="do?command=Labrary">
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="permission"></label>
            <div class="col-md-4">
                <button id="permission" name="permission" value="1" class="btn btn-success">Подписка</button>
            </div>
        </div>

        <div class=col-md-2>
            <div class="list-group">
                <c:forEach items="${textFrees}" var="textFree">
                    <button  class="btn btn-success-action" name="read"
                            id="read" value="${textFree.id}" >
                        ${textFree.textFree}
                    </button>
                </c:forEach>
            </div>


            <fieldset>

                <!-- Form Name -->
                <legend>Выход${permission}</legend>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="logout"></label>
                    <div class="col-md-4">
                        <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                    </div>
                </div>

            </fieldset>
        </form>
                   </c:otherwise>
</c:choose>

 </div>
</body>
</html>