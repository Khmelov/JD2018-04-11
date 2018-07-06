


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

                 <!-- Password input-->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="password">Password</label>
                     <div class="col-md-4">
                         <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
                                value="${user.password}">
                         <span class="help-block">${help_password}</span>
                     </div>
                 </div>

                 <!-- Button -->
                 <div class="form-group">
                     <label class="col-md-4 control-label" for="Update"></label>
                     <div class="col-md-4">
                         <button id="Update" name="Update" class="btn btn-success">Обновить</button>
                     </div>
                 </div>

             </fieldset>
         </form>




    <p>Мои заказы:</p>

       <table class="table">
            <theorder>
            <tr>

                <th scope="col">Начало заказа</th>
                <th scope="col">Длительность</th>
                <th scope="col">Стоимость</th>
                <th scope="col">Скидка</th>
                <th scope="col">Итоговая стоимость</th>
                <th scope="col">Машина</th>

            </tr>
            </theorder>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>

                    <td>${order.startorder}</td>
                    <td>${order.tenancy}</td>
                    <td>${order.cost}</td>
                    <td>${order.discount}</td>
                    <td>${order.realcost}</td>
                    <c:forEach  var="avto" items="${avtos}">
                          <c:if test="${avto.id == order.avtos_id}">
                               <td>"${avto.mark}" "${avto.model}" "${avto.ngos}"</td>
                          </c:if>
                    </c:forEach>


                </tr>
            </c:forEach>


            </tbody>
        </table>

</div>
</body>
</html>
