<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.java_jo_2024.User" %>
<html>
<head>
    <title>Concours pour gagner des places</title>
    <link href="menuConcours.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    request.setAttribute("user", user);
    request.setAttribute("userID", user.getId);
%>
<div class="menu-container">
<h1>Concours pour gagner des places</h1>
<form method="post" action="${pageContext.request.contextPath}/resultatConcours">
    <label for="ConnaissancesSportives">Connaissances Sportives:</label>
    <p>Est ce que la France à gagné plus de trente cinq médailles lors des dernier JO de Tokyo</p>
    <input type="radio" id="radio" name="connsport" value="radiobtn"><br>

    <label for="Predictions">Prédictions :</label>
    <p>Qui gagnera le plus de médailles aux JO de Paris qui arriveront</p>
    <select name="prediction" id="prediction">
        <option value="France">France</option>
        <option value="Japon">Japon</option>
        <option value="US">US</option>
        <option value="GBR">GBR</option>
        <option value="Chine">Chine</option>
        <option value="Italie">Italie</option>
    </select>
    <br>

    <label for="DefiVirtuels">Défi virtuel :</label>
        <p>Quel est ce défi ?</p>
        <input type="radio" id="radio" name="defi" value="defi"><br>

    <input type="submit" value="Valider">
</form>
</div>
</body>
</html>
