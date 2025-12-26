<!DOCTYPE html>


<html lang="en">
<head>
    <title>Test JSP Tag</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@ page import="java.util.Date" %>
    <c:set var="currentTime" value="<%= new java.util.Date() %>" />

    Current time is ${currentTime}
</body>
</html>
