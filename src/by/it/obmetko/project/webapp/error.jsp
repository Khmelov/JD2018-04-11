<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
     <div class="alert alert-danger" role="alert">
                 <p><b>${error}</b></p>
                 <p>
                       <a data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                         press for details
                       </a>
                 </p>
                 <div class="collapse" id="collapseExample">
                       <div class="card card-body">
                             <p>${error_details}</p>
                       </div>
                 </div>

             </div>

    <p>Cmd ERROR: ${error}</p>
    <p>Cmd Message: ${message}</p>
</div>
</body>
</html>


