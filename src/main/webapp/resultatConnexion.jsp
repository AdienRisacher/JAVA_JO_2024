<%@ page import="com.example.java_jo_2024.User" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat de la connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        p {
            text-align: center;
            font-size: 16px;
            margin-bottom: 20px;
        }

        .error-message {
            color: #ff0000;
            text-align: center;
            font-size: 16px;
            margin-bottom: 20px;
        }

        .btn-connexion {
            display: block;
            width: 200px;
            margin: 0 auto;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            font-size: 14px;
        }

        .btn-connexion:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Résultat de la connexion</h1>

<%-- Récupérer les données du formulaire --%>
<%
    User user = (User) request.getAttribute("user");
    request.setAttribute("user", user);
    request.getRequestDispatcher("concoursQuestionnaire.jsp").forward(request, response);
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
<h1>Jeu concours</h1>
<form method="post" action="${pageContext.request.contextPath}/concoursQuestionnaire.jsp">
    <input type="submit" value="Participer">
</form>
<%
} else {
    String error = (String) request.getAttribute("error");
    // Connexion échouée
%>
<p class="error-message">Échec de la connexion. ${error}.</p>
<a href="connexion.jsp" class="btn-connexion">Retourner à la page de connexion</a>
<%
    }
%>
<a href="index.jsp" class="btn-connexion">Retourner à la page d'accueil</a>
</body>
</html>
