<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
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
            Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
        %>
            <li><%= entry.getKey() %> : <%= entry.getValue() %></li>
        <%
                }
            }
        %>
    </ul>
</body>
</html>
