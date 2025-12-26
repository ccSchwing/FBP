<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=">
<head>
    <meta charset="UTF-8">
    <title>Welcome to JSP Application</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to JSP Application</h1>
        <p>Current date and time: <%= new java.util.Date() %></p>
        
        <h2>Getting Started</h2>
        <ul>
            <li>Edit JSP files in the WebContent directory</li>
            <li>Create servlets in the src directory</li>
            <li>Update web.xml for servlet mappings</li>
        </ul>
        
        <p><a href="sample.jsp">View Sample Page</a></p>
    </div>
</body>
</html>
