<%@ page import="com.example.java_jo_2024.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: risac
  Date: 21/06/2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Liste User</h1>
<ul>
    <% for (User user : (ArrayList<User>) request.getAttribute("listeUser")) { %>
    <li>
        <div class="menu-item active">
            <a><h3><%= user.getNom() %></h3></a>
        </div>
        <p><%= user.getEmail() %></p>
    </li>
    <% } %>
</ul>
</body>
</html>
