<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/14/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  </head>
  <body>
  <form method="get" action="/search">
    <input type="text" name="nameStudent" />
    <button type="submit">Search</button>
  </form>
  <table class="table table-striped">
     <tr>
       <td>ID</td>
       <td>Name</td>
       <td>Gender</td>
       <td>Language</td>
     </tr>
     <c:forEach items="${studentList}" var="student">
       <tr>

         <td>${student.id}</td>

         <td>${student.name}</td>

         <c:if test="${student.gender==1}">
           <td>Male</td>
         </c:if>

         <c:if test="${student.gender==0}">
           <td>Female</td>
         </c:if>

         <td>
           <c:forEach items="${student.languages}" var="lang">
             <span>${lang}</span>
           </c:forEach>
         </td>

       </tr>
     </c:forEach>
  </table>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
