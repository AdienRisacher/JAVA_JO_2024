<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    <link href="connexion.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Connexion</h1>
<form method="get" action="${pageContext.request.contextPath}/resultatConnexion">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="motDePasse">Mot de passe:</label>
    <input type="password" id="motDePasse" name="mdp" required><br>
    <br>
    <a href="${loginURL}" class="btn-google">Login with Google</a>

    <br>
    <input type="submit" value="Se connecter">
</form>

</body>
</html>
