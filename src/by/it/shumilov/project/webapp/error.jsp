<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <hr>
    <p>ERROR:<br> ${errMessage}</p>
    <hr>
    <p>STACK:<br> ${errStack}</p>
    <hr>
 </div>
</body>
</html>


