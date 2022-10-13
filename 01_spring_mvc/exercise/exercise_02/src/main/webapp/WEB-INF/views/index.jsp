<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 9/26/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Dictionary</h3>
  <form action="/change" method="get">
    <input type="text" name="eng">
    <button type="submit">Convert</button>
  </form>
  <h6 style="color: brown">Result:${result}</h6>
  </body>
</html>
