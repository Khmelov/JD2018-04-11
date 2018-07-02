<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<c:choose>
    <c:when test="${user==null}">
    <%@ include file="include/adminka.htm" %><div class="container">
    </c:when>
    <c:when test="${admin==null}">
        <%@ include file="include/menu.htm" %><div class="container">
    </c:when>
</c:choose>
     <div class="container">
         <div class="row">
             <div class=col-md-2>Наименование</div>
             <div class=col-md-2>Количество</div>
             <div class=col-md-2>Цена</div>
             <div class=col-md-2>Номер заказа</div>
         </div>
     </div>
     <div class="container">
         <c:forEach items="${itemlist}" var="item">
             <div class="row">
                 <div class=col-md-2>
                     <p>${item.name}</p>
                 </div>
                 <div class=col-md-2>
                     <p>${item.amount}</p>
                 </div>
                 <div class=col-md-2>
                      <p>${item.price}</p>
                 </div>
                 <div class=col-md-2>
                   <p>${item.order_id}</p>
                 </div>
             </div>
             <p></p>
         </c:forEach>
     </div>
         <form class="update-list" action="do?command=profile" method=POST>
         <button id="Return" value="Return" name="Return" class="btn btn-success col-md-2">
             Вернуться
         </button>
         </form>
 </div>
</body>
</html>

