<%@ page import="com.example.java_jo_2024.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat de la connexion</title>
</head>
<body>
<h1>Résultat de la connexion</h1>
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
        // Connexion réussie
%>
<p>Connexion réussie pour l'email : <%= user.getEmail() %></p>
<%
} else {
    String error = (String) request.getAttribute("error");
    // Connexion échouée
%>
<p>Échec de la connexion. ${error}.</p>
<jsp:include page="connexion.jsp"></jsp:include>
<%
    }
%>
</body>
</html>
