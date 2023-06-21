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
    String email = request.getParameter("email");
    String motDePasse = request.getParameter("motDePasse");

    // Vérifier les informations de connexion ici (par exemple, en les comparant à une base de données)
    boolean estValide = false; // À remplacer par la logique de validation réelle

    if (estValide) {
        // Connexion réussie
%>
<p>Connexion réussie pour l'email : <%= email %></p>
<%
} else {
    // Connexion échouée
%>
<p>Échec de la connexion. Veuillez vérifier votre email et votre mot de passe.</p>
<%
    }
%>
</body>
</html>
