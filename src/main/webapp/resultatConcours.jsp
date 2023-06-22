<%@ page import="com.example.java_jo_2024.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat du jeux concours</title>
</head>
<body>
<h1>Résultat du jeu concours</h1>
<%-- Récupérer les données du formulaire --%>
<%
    User user = (User) request.getAttribute("user");
    boolean estValide;
    // Vérifier les informations de connexion ici (par exemple, en les comparant à une base de données)
    if(user != null) {
        estValide = true; // À remplacer par la logique de validation réelle
    }else {
        estValide = false;
    }
    if (estValide) {
        // Concours Gagné
%>
<p>Gagné : <%= user.getName() %></p>
<%
} else {
    String error = (String) request.getAttribute("error");
    // Concours Perdu
%>
<p>Perdu : <%= user.getName() %></p>
<%
    }
%>
</body>
</html>
