<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
</head>
<body>
    <h1>Connexion</h1>
    <form method="get" action="${pageContext.request.contextPath}/api/session/login">
        <label>
            Nom
            <input type="text" name="username" placeholder="Nom" required>
        </label>
        <label>
            Rôle
            <select name="role">
                <option value="user">user</option>
                <option value="admin">admin</option>
            </select>
        </label>
        <button type="submit">Se connecter</button>
    </form>
</body>
</html>
