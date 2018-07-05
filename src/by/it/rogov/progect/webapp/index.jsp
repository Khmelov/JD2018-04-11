<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Содержание </p>
<div class=col-md-2>
    <div class="list-group" ${hidden}>
        <c:forEach items="${textFrees}" var="textFree">
               <li  class="list-group-item" name="${textFree.id}" id="Selecte">
                 ${textFree.textFree}
               </li>
         </c:forEach>
    </div>
</div>
</div>
</body>
</html>
