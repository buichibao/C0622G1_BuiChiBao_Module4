<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/14/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/convert" method="get">
    <input type="number" name="firstNumber">
    <input type="number" name="secondNumber">
    <br>
    <br>
    <button value="+" name="opera">Addition(+)</button>
    <button value="-" name="opera">Subtraction(-)</button>
    <button value="*" name="opera">Multiplication(X)</button>
    <button value="/" name="opera">Division(/)</button>
  </form>
  ${result}
  </body>
</html>
