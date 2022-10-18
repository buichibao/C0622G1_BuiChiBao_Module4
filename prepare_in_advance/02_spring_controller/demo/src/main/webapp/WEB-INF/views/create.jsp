<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 10/17/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form:form modelAttribute="student" method="post" action="/save">
     <pre>ID       :<form:input path="id" /></pre>
     <pre>Name     :<form:input path="name"/></pre>
     <pre>Gender   :<form:radiobutton path="gender" value="1" label="Male"/> <form:radiobutton path="gender" value="0" label="Female"/></pre>
     <pre>Language :<form:checkboxes path="languages" items="${languagesList}"/></pre>
     <button type="submit">Create</button>
  </form:form>
</body>
</html>
