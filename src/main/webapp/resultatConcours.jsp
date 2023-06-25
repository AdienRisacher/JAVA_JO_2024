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
    boolean estValide = request.getAttribute("won");;
    if (estValide) {
        // Concours Gagné
%>
<p>Gagné : <%= user.getName() %></p>
<%
} else {
    // Concours Perdu
%>
<p>Perdu : <%= user.getName() %></p>
<%
    }
%>
</body>
</html>
