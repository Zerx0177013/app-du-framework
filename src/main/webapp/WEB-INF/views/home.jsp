<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>
</head>
<body>
    <h1>Bienvenue ${sessionScope.user} (${sessionScope.role})</h1>

    <button onclick="appeler('/api/session/hello')">Hello</button>
    <button onclick="appeler('/api/session/admin')">Admin</button>
    <button onclick="appeler('/api/session/logout')">Logout</button>

    <p>Résultat : <strong id="resultat">—</strong></p>
    <a href="${pageContext.request.contextPath}/api/session/login-page">Retour connexion</a>

    <script>
        const ctx = "${pageContext.request.contextPath}";
        async function appeler(url) {
            const res = await fetch(ctx + url);
            document.getElementById("resultat").textContent =
                res.ok ? await res.text()
                       : res.status === 403 ? "403 (rôle insuffisant)" : res.status + " (non connecté)";
        }
    </script>
</body>
</html>
