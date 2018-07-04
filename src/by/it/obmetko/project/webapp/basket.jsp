<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
 <p><b><c:out value="${user.login}"/>, у вас в корзине:</b></p>
          <table class="table">
              <thead>
                  <tr>
                      <th scope="col">Автор</th>
                      <th scope="col">Название</th>
                      <th scope="col">Цена</th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach items="${purchases}" var="book">
                      <tr>
                          <td>${book.author}</td>
                          <td>${book.name}</td>
                          <td>${book.price}</td>
                      </tr>
                  </c:forEach>
              </tbody>
          </table>
          <br><br>

             <c:if test="${user!=null}">
                  <button id="No action" value="No action" name="No action" class="btn btn-success" disabled>
                      Оформить заказ
                  </button>
              </c:if>
          <br><br>

  <!--<p><b>${purchases_table}</b></p>-->

</div>
</body>
</html>