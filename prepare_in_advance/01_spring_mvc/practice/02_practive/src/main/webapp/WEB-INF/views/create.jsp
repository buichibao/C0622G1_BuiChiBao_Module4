<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/12/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save">
   <pre>ID     :<input type="number" name="id"/></pre>
   <pre>Name   :<input type="text" name="name"/></pre>
   <pre>Email  :<input type="text" name="email"/></pre>
   <pre>Address:<input type="text" name="address"/></pre>
   <button type="submit">Create</button>
</form>
</body>
</html>
