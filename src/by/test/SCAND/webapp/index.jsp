<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>


<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
            <th scope="col">Цена</th>
            <th scope="col">Фото</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="goods" items="${goods}">

        <p>
          <button class="btn btn-outline-info" type="button" data-toggle="collapse" data-target="#${goods.idgoods}"
          aria-expanded="false" aria-controls="${goods.idgoods}">
            ${goods.name}
          </button>

        </p>
        <div class="collapse" id="${goods.idgoods}">
          <div class="card card-body">
            ${goods.description}
            <form class="form-horizontal" action="do?command=Buy" method="post">
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-warning">Купить</button>
                </div>
             </form>
            </div>

     </div>

     <div class="alert alert-primary" role="alert">
                 Цена: ${goods.price}
              </div>
        <!--       <tr>
                <td>${goods.name}</td>
                <td>${goods.description}</td>
                <td>${goods.price}</td>
                <td>${goods.photo}</td>
                <td>
                <form class="form-horizontal" action="do?command=Buy" method="post">
                    <div class="col-md-4">
                        <button id="submit" name="submit" class="btn btn-warning">Купить</button>
                    </div>
                 </form>

                </td>
            </tr>  -->
        </c:forEach>
        </tbody>
    </table>

     <mytag:paginator count="${count}" step="5" urlprefix="?start="/>

</div>

</body>
</html>
