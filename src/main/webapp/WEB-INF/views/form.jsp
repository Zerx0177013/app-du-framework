<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/api/binder/user">
    <label>
        Username
        <input type="text" name="username" placeholder="Username">
    </label>
    <label>
        Email
        <input type="email" name="email" placeholder="Email">
    </label>
    <fieldset>
        <legend>Aretina</legend>
        <label>
            Name
            <input type="text" name="aretina.name" placeholder="Aretina name">
        </label>
        <label>
            Description
            <textarea name="aretina.description" placeholder="Aretina description"></textarea>
        </label>
    </fieldset>
    <button type="submit">Test binder</button>
</form>
</body>
</html>
