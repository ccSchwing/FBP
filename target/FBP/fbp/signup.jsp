<!DOCTYPE html>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page
import="java.security.MessageDigest" %> <%@ page
import="com.planb.utils.FBPUtils" %>

<html>
  <head>
    <title>FBP Registration</title>
  </head>

  <body>
	<% String errorMessage = (String) request.getAttribute("errorMessage");
	   if (errorMessage != null) { %>
	   <div style="color: red;"><b><%= errorMessage %></b></div>
	<% } %>
    <form action="${pageContext.request.contextPath}/FBPValidateRegData" method="post">
      First name: <input type="text" name="firstName" />

      <br /><br />

      Last name: <input type="text" name="lastName" />

      <br /><br />
	  Email: <input type="text" name="emailAddress" />
	  <br /><br />
	  Display Name: <input type="text" name="displayName" />
	  <br /><br />
      Password: <input type="password" name="password" />
      <c:set var="password" value="<%= request.getParameter(\"password\") %>" />
      <c:set var="hashedPassword" value="junk"/>
	  <br /><br />
      Password: <input type="password" name="password2" />
      <c:set var="password2" value="<%= request.getParameter(\"password2\") %>" />

      <input type="submit" value="Submit" />
    </form>
    <br /><br />
  </body>
</html>
