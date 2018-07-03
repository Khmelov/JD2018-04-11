<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
%@ page  language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p><b><c:out value="${category.categoryName}"/></b></p>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Автор</th>
                        <th scope="col">Название</th>
                        <th scope="col">Цена</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books_in_category}" var="book">
                        <form class="form-horizontal" action="do?command=category&categoryId=${category.id}&bookToBasketId=${book.id}" method="post">
                            <tr>
                                <td>${books.author}</td>
                                <td>${books.name}</td>
                                <td>${books.price}</td>
                                <td>
                                    <c:if test="${user!=null}">
                                        <button id="toBasket" value="toBasket" name="toBasket" class="btn btn-success">
                                            в корзину
                                        </button>
                                    </c:if>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

    <div class="row">
        <mytag:paginator count="${booksSize}" step="10" urlprefix="do?command=category&categoryId=${category.id}&step=10&start="/>
    </div>


     <p>Cmd ERROR: ${error}</p>
     <p>Cmd Message: ${message}</p>
     <br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>