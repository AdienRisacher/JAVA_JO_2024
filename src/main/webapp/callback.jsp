<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Callback</title>
    <link href="callback.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Connexion</h1>
<%
    String email = (String) request.getSession().getAttribute("email");
    if (email != null) {
%>
<p>Connecté en tant que : <%= email %></p>
<%
} else {
%>
<p>Erreur lors de la connexion</p>
<%
    }
%>
<a href="index.jsp">Retour à la page d'accueil</a>
</body>
</html>
