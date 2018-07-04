<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
   <p>Пользователь: ${user}</p>

       <form class="form-horizontal" method="post" action="do?command=Profile">
           <fieldset>

              <!-- Form Name -->
                          <legend>Sign Up Form</legend>

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
                              <label class="col-md-4 control-label" for="update"></label>
                              <div class="col-md-4">
                                  <button id="update" name="update" class="btn btn-success">Обновить</button>
                              </div>
                          </div>

           </fieldset>
       </form>

       <h2>Мои объявления</h2>
           <table class="table table-striped">
                <thead>
               <tr>
                   <th scope="col">Описание</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Размер</th>
                    <th scope="col">Ткань</th>
                    <th scope="col">Цвет</th>
                    <th scope="col">Пол</th>
                    <th scope="col">Производитель</th>
               </tr>
               </thead>
               <tbody>
               <c:forEach var="ad" items="${ads}">
                   <tr>
                       <td>${ad.description}</td>
                       <td>${ad.price}</td>
                       <td>${ad.size}</td>
                       <td>${ad.fabric}</td>
                       <td>${ad.colour}</td>
                       <td>${ad.sex}</td>
                       <td>${ad.producer}</td>
                   </tr>
               </c:forEach>


               </tbody>
           </table>


           <form class="form-horizontal" method="post" action="do?command=Profile">
               <fieldset>

                   <!-- Form Name -->
                   <legend>Выход</legend>

                   <!-- Button -->
                   <div class="form-group">
                       <label class="col-md-4 control-label" for="logout"></label>
                       <div class="col-md-4">
                           <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                       </div>
                   </div>

               </fieldset>
           </form>
</div>
</body>
</html>
