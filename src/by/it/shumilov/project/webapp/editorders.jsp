<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<style>
    .col-md-1 {
    max-width: 7%;
    }

    .col-md-2 {
    max-width: 13.666666%;
    }

    .col-md-3 {
    max-width: 17.333333%;
    }
    .col, .col-1, .col-10, .col-11, .col-12,
    .col-2, .col-3, .col-4, .col-5, .col-6,
    .col-7, .col-8, .col-9,
     .col-auto, .col-lg, .col-lg-1, .col-lg-10,
     .col-lg-11, .col-lg-12, .col-lg-2,
     .col-lg-3, .col-lg-4, .col-lg-5,
     .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9,
     .col-lg-auto, .col-md, .col-md-1, .col-md-10,
      .col-md-11, .col-md-12, .col-md-2, .col-md-3,
       .col-md-4, .col-md-5, .col-md-6, .col-md-7,
       .col-md-8, .col-md-9, .col-md-auto, .col-sm,
        .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12,
         .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5,
         .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9,
         .col-sm-auto, .col-xl, .col-xl-1, .col-xl-10,
         .col-xl-11, .col-xl-12, .col-xl-2, .col-xl-3,
          .col-xl-4, .col-xl-5, .col-xl-6, .col-xl-7,
          .col-xl-8, .col-xl-9, .col-xl-auto {
    position: relative;
    width: 100%;
    min-height: 1px;
    padding-right: 0px;
    padding-left: 0px;
    }

    .container {

        padding-right: 0px;
        padding-left: 0px;
</style>


<div class="container">
    <%@ include file="include/menu.htm" %>





 <c:choose>
 <c:when test="${fn:length(orders)!=0}">



    <p>Действующие заказы: </p>
<div class="container">


    <div class="container">
        <div class="row">

            <div class=col-md-2>Начало заказа</div>
            <div class=col-md-2>Длительность</div>
            <div class=col-md-2>Окончание заказа</div>
            <div class=col-md-2>Стоимость</div>
            <div class=col-md-1>Скидка</div>
            <div class=col-md-1>Итоговая стоимость</div>
            <div class=col-md-2>Машина</div>
            <div class=col-md-2>Паспорт</div>


        </div>
    </div>

    <div class="container">
        <c:forEach items="${orders}" var="order">
            <form class="update-order-${order.id}" action="do?command=EditOrders" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${order.id}"/>
                    <div class=col-md-2>
                        <input id="startorder" class="form-control input-md" name="startorder" type="date"
                               value=<fmt:formatDate value="${order.startorder}" pattern="yyyy-MM-dd" /> readonly/>
                    </div>
                    <div class=col-md-2>
                        <input id="tenancy" class="form-control input-md" name="tenancy"
                               value="${order.tenancy}" readonly/>
                    </div>
                    <div class=col-md-2>
                        <input id="endorder" class="form-control input-md" name="endorder" type="date"
                               value==<fmt:formatDate value="${order.startorder}" pattern="yyyy-MM-dd" /> />
                    </div>
                    <div class=col-md-2>
                        <input id="cost" class="form-control input-md" name="cost"
                               value="${order.cost}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="discount" class="form-control input-md" name="discount"
                               value="${order.discount}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="realcost" class="form-control input-md" name="realcost"
                               value="${order.realcost}"/>
                    </div>
                    <input name="avtos_id" type="hidden" value="${order.avtos_id}"/>
                    <div class=col-md-2>
                    <c:forEach  var="avto" items="${avtos}">
                          <c:if test="${avto.id == order.avtos_id}">
                          <input id="avtos_idd" class="form-control input-md" name="avtos_idd"
                                                         value="${avto.mark} ${avto.model}, ${avto.ngos}" readonly/>
                          </c:if>
                    </c:forEach>
                    </div>

                    <input name="pasports_id" type="hidden" value="${order.passports_id}"/>

                    <div class=col-md-3>
                     <c:forEach items="${passports}" var="passport">
                         <c:if test="${passport.id == order.passports_id}">
                               <input id="pasports_idd" class="form-control input-md" name="pasports_idd"
                                                                         value="${passport.pasportid}" readonly/>
                         </c:if>

                     </c:forEach>

                    </div>


                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>


                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>






 </c:when>
 </c:choose>


 <c:choose>
  <c:when test="${fn:length(ordersend)!=0}">
         <p>Завершённые заказы:</p>

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
