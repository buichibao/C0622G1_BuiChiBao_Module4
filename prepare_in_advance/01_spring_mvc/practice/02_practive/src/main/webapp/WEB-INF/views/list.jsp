<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/12/2022
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

  <head>
    <title>Customer List</title>
  </head>

  <body>
  <a href="/create">Create Customer</a>
   <table>
     <tr>
       <th>ID</th>
       <th>Name</th>
       <th>Email</th>
       <th>Address</th>
     </tr>
     <c:forEach var="customer" items="${customerList}">
       <tr>
         <td>${customer.id}</td>
         <td>${customer.name}</td>
         <td>${customer.email}</td>
         <td>${customer.address}</td>
       </tr>
     </c:forEach>

   </table>
  </body>
</html>
