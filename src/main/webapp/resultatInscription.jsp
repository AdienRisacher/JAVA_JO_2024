<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat de l'inscription</title>
</head>
<body>
<h1>Résultat de l'inscription</h1>
<%-- Récupérer les données du formulaire --%>
<%
    String nom = request.getParameter("nom");
    String email = request.getParameter("email");
    String motDePasse = request.getParameter("motDePasse");

    // Traiter les données ici (par exemple, enregistrer dans une base de données)

    // Afficher un message de succès
%>
<p>Merci, <%= nom %>, pour votre inscription!</p>
<p>Votre email (<%= email %>) a été enregistré avec succès.</p>
</body>
</html>
