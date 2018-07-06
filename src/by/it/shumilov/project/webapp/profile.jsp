<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>


     <h1>Данные профиля ${user.login}</h1>
         <form class="form-horizontal" method="post" action="do?command=Profile">
             <fieldset>

                 <!-- Text input-->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="login">Login</label>
                     <div class="col-md-4">
                         <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                                value="${user.login}">
                         <span class="help-block">${help_login}</span>
                     </div>
                 </div>

                 <!-- Text input-->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="email">Email</label>
                     <div class="col-md-4">
                         <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                                value="${user.email}">
                         <span class="help-block">${help_email}</span>
                     </div>
                 </div>



                 <!-- Button -->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="UpdateUser"></label>
                     <div class="col-md-4">
                         <button id="UpdateUser" name="UpdateUser" value="UpdateUser" class="btn btn-success">Обновить</button>
                     </div>
                 </div>

             </fieldset>
         </form>


 <c:choose>
 <c:when test="${fn:length(orders)!=0}">



    <p>Мои действующие заказы заказы: </p>




       <table class="table">
            <theorder>
            <tr>

                <th scope="col">Начало заказа</th>
                <th scope="col">Длительность</th>
                <th scope="col">Стоимость</th>
                <th scope="col">Скидка</th>
                <th scope="col">Итоговая стоимость</th>
                <th scope="col">Машина</th>
                <th scope="col">Паспорт</th>
            </tr>
            </theorder>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>

                    <td><fmt:formatDate value="${order.startorder}" pattern="yyyy-MM-dd" /></td>
                    <td>${order.tenancy}</td>
                    <td>${order.cost}</td>
                    <td>${order.discount}</td>
                    <td>${order.realcost}</td>
                    <c:forEach  var="avto" items="${avtos}">
                          <c:if test="${avto.id == order.avtos_id}">
                               <td>${avto.mark} ${avto.model}, ${avto.ngos}</td>
                          </c:if>
                    </c:forEach>
                    <c:forEach items="${passports}" var="passport">
                        <c:if test="${passport.id == order.passports_id}">
                             <td>${passport.pasportid}</td>
                        </c:if>

                    </c:forEach>

                </tr>

            </c:forEach>


            </tbody>
        </table>

 </c:when>
 </c:choose>


 <c:choose>
  <c:when test="${fn:length(ordersend)!=0}">
         <p>Мои завершённые заказы заказы:</p>

               <table class="table">
                    <theorder>
                    <tr>

                        <th scope="col">Начало заказа</th>
                        <th scope="col">Длительность</th>
                        <th scope="col">Окончание заказа</th>
                        <th scope="col">Стоимость</th>
                        <th scope="col">Скидка</th>
                        <th scope="col">Итоговая стоимость</th>
                        <th scope="col">Машина</th>
                        <th scope="col">Паспорт</th>

                    </tr>
                    </theorder>
                    <tbody>
                    <c:forEach var="orderend" items="${ordersend}">
                        <tr>

                            <td><fmt:formatDate value="${orderend.startorder}" pattern="yyyy-MM-dd" /></td>
                            <td>${orderend.tenancy}</td>
                            <td><fmt:formatDate value="${orderend.endorder}" pattern="yyyy-MM-dd" /></td>
                            <td>${orderend.cost}</td>
                            <td>${orderend.discount}</td>
                            <td>${orderend.realcost}</td>
                            <c:forEach  var="avto" items="${avtos}">
                                  <c:if test="${avto.id == orderend.avtos_id}">
                                       <td>${avto.mark} ${avto.model}, ${avto.ngos}</td>
                                  </c:if>
                            </c:forEach>

                            <c:forEach items="${passports}" var="passport">
                                <c:if test="${passport.id == orderend.passports_id}">
                                     <td>${passport.pasportid}</td>
                                </c:if>

                            </c:forEach>



                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
 </c:when>
 </c:choose>
</div>
</body>
</html>
