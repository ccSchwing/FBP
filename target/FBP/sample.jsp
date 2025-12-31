<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=">
<head>
    <meta charset="UTF-8">
    <title>Sample JSP Page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Sample JSP Page</h1>
        
        <h2>JSP Expression Examples</h2>
        <p>Server: <%= request.getServerName() %></p>
        <p>Port: <%= request.getServerPort() %></p>
        <p>Context Path: <%= request.getContextPath() %></p>
        
        <h2>Loop Example</h2>
        <ul>
            <% for (int i = 1; i <= 5; i++) { %>
                <li>Item <%= i %></li>
            <% } %>
        </ul>
        
        <p><a href="index.jsp">Back to Home</a></p>
    </div>
</body>
</html>
