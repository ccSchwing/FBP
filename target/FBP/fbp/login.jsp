<!DOCTYPE html>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page
import="java.security.MessageDigest" %> <%@ page
import="com.planb.utils.FBPUtils" %>

<html>
  <head>
    <title>FBP Login</title>
  </head>

  <body>
	<% String errorMessage = (String) request.getAttribute("errorMessage");
	   if (errorMessage != null) { %>
	   <div style="color: red;"><b><%= errorMessage %></b></div>
	<% } %>
    <form action="${pageContext.request.contextPath}/FBPLogin" method="post">

	  Login: <input type="text" name="loginId" />
	  <br /><br />
      Password: <input type="password" name="password" />
      <input type="submit" value="Login!" />
    </form>
    <br /><br />
  </body>
</html>
