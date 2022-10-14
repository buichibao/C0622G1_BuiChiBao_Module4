<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/14/2022
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h1>Sandwich Condiments</h1>
  <form action="/save" method="get">
    <input type="checkbox" name="choose" value="Lettuce">Lettuce
    <input type="checkbox" name="choose" value="Tomato">Tomato
    <input type="checkbox" name="choose" value="Mustard">Mustard
    <input type="checkbox" name="choose" value="Sprouts">Sprouts
    <hr>
    <br>
    <input type="submit" value="Save">
  </form>
    <c:forEach items="${result}" var="r">
        <span>${r},</span>
    </c:forEach>
  </body>
</html>
