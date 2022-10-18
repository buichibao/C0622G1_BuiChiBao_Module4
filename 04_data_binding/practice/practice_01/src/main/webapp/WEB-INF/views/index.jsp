<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/17/2022
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form action="/save" method="post" modelAttribute="employee">
    <pre>ID             :<form:input path="id"/></pre>
    <pre>Name           :<form:input path="name"/></pre>
    <pre>Contact Number :<form:input path="contactNumber"/></pre>
    <button type="submit">create</button>
  </form:form>
  </body>
</html>
