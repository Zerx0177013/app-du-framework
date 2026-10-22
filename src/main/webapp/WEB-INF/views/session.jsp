<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session test</title>
    <style>
        body { font-family: sans-serif; max-width: 700px; margin: 2rem auto; padding: 0 1rem; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: .4rem .6rem; text-align: left; }
        form { margin: .8rem 0; }
        .message { background: #eef6ee; border: 1px solid #9c9; padding: .5rem .8rem; }
    </style>
</head>
<body>
<h1>Session test</h1>

<%
    String ctx = request.getContextPath();
    List<?> message = (List<?>) request.getAttribute("message");
    if (message != null && !message.isEmpty()) {
%>
    <p class="message"><%= message.get(0) %></p>
<% } %>

<p>Session id : <code><%= session.getId() %></code></p>

<h2>Current HttpSession contents</h2>
<table>
    <tr><th>Key</th><th>Value</th></tr>
<%
    List<String> names = Collections.list(session.getAttributeNames());
    if (names.isEmpty()) {
%>
    <tr><td colspan="2"><em>empty</em></td></tr>
<%
    }
    for (String name : names) {
%>
    <tr><td><%= name %></td><td><%= session.getAttribute(name) %></td></tr>
<% } %>
</table>

<h2>Actions</h2>

<form method="post" action="<%= ctx %>/api/session/set">
    <input type="text" name="key" placeholder="key" required>
    <input type="text" name="value" placeholder="value">
    <button type="submit">setAttribute</button>
</form>

<form method="post" action="<%= ctx %>/api/session/remove">
    <input type="text" name="key" placeholder="key" required>
    <button type="submit">removeAttribute</button>
</form>

<form method="post" action="<%= ctx %>/api/session/destroy">
    <button type="submit">destroy (clear everything)</button>
</form>

<p><a href="<%= ctx %>/api/session/page">Refresh</a></p>

<h2>Plain-text routes</h2>
<form method="get" action="<%= ctx %>/api/session/login">
    <input type="text" name="username" placeholder="username" required>
    <button type="submit">/session/login</button>
</form>
<ul>
    <li><a href="<%= ctx %>/api/session/me">/session/me</a></li>
    <li><a href="<%= ctx %>/api/session/logout">/session/logout</a></li>
</ul>
</body>
</html>
