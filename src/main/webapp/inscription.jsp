<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
    <link href="inscription.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Inscription</h1>
<form method="post" action="${pageContext.request.contextPath}/resultatInscription">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="motDePasse">Mot de passe:</label>
    <input type="password" id="motDePasse" name="mdp" required><br>
    <a href="${loginURL}" class="btn-google">Login with Google</a>
    <input type="submit" value="S'inscrire">
</form>
</body>
</html>
