<%--
  Created by IntelliJ IDEA.
  User: risac
  Date: 24/06/2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String code = request.getParameter("code");
%>
<h1> <%= code.toString() %> </h1>
</body>
</html>
