<!DOCTYPE html>
<html lang="en">
<head>
<title>Java Class Test</title>
</head>
<body>
<%@ page import="com.planb.utils.MyUtils" %>
<%
    com.planb.utils.MyUtils utils = new com.planb.utils.MyUtils();
    String message = utils.getMessage();
    String loudMessage = utils.makeItLoud("this is loud");
%>
<p>Message from Utils class: <%= message %></p>
<p>Loud message: <%= loudMessage %></p>
</body>
</html>