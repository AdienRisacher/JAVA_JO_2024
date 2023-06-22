<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
<form method="post" action="${pageContext.request.contextPath}/resultatConnexion">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="motDePasse">Mot de passe:</label>
    <input type="password" id="motDePasse" name="mdp" required><br>

    <input type="submit" value="Se connecter">
</form>
</body>
</html>
