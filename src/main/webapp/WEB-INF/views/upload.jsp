<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/api/binder/upload" enctype="multipart/form-data">
    <label>
        Titre
        <input type="text" name="titre" placeholder="Titre">
    </label>
    <label>
        Photo (FileUpload)
        <input type="file" name="photo" accept="image/*">
    </label>
    <label>
        Documents (FileUpload[])
        <input type="file" name="documents" multiple>
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
    <button type="submit">Test upload binder</button>
</form>
</body>
</html>
