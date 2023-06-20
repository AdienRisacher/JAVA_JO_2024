<%@ page import="com.example.java_jo_2024.Concours" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Concours pour gagner des places</title>
    <link href="menuConcours.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="menu-container">
<h1>Concours pour gagner des places</h1>
<ul>
    <% for (Concours concours : (ArrayList<Concours>) request.getAttribute("concoursList")) { %>
    <li>
        <div class="menu-item active">
        <a><h3><%= concours.getNom() %></h3></a>
        </div>
        <p><%= concours.getDescription() %></p>
    </li>
    <% } %>
</ul>
</div>
</body>
</html>
