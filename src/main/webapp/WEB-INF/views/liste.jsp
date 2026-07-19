<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="roro.app.entity.User" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <ul>
        <%
            List<User> utilisateurs = (List<User>) request.getAttribute("utilisateurs");
            
            if (utilisateurs != null) {
                for (User user : utilisateurs) {
        %>
                    <li><%= user.getUsername() %> - <%= user.getEmail() %></li>
        <%
                } 
            }
        %>
    </ul>
</body>
</html>