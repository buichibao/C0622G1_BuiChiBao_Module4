<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/17/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form modelAttribute="login" method="post" action="/check">
    <fieldset>
      <label>Login</label>
      <table>
        <tr>
          <td>Account :<form:input path="account"/></td>
        </tr>
        <tr>
          <td>Password:<form:input path="password"/></td>
        </tr>
        <tr>
          <td><form:button>Login</form:button></td>
        </tr>
      </table>
    </fieldset>
  </form:form>
  </body>
</html>
