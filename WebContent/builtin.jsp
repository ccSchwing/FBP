<!DOCTYPE html>
<html lang="en">

<head>
<title>Built-in Objects in JSP</title>  
</head>
Reqiest user agent: <%=request.getHeader("User-Agent") %>
<br><br>
Server Info: <%= application.getServerInfo() %>
<br><br>
Session ID: <%= session.getId() %>
</html>