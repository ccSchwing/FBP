<!DOCTYPE html>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="com.planb.utils.FBPUtils" %>

<html>
  <head>
    <title>FBP Signup Complete</title>
  </head>

  <body>
    <br /><br />
    	<% String Success = (String) request.getAttribute("Success");
	   if (Success != null) { %>
	   <div style="color: green;"><b><%= Success %></b></div>
	<% } %>
    <c:set var="password" value="<%= request.getParameter(\"password\") %>" />
    <c:set var="validatedhashedPassword" value="<%= request.getParameter(\"validatedHashedPassword\") %>" />
    <% String password = request.getParameter("password");
       String hashedPassword = request.getParameter("validatedHashedPassword");
       %>
    Password: <c:out value="${password}" />
    Hashed Password:
    <c:out value="${validatedHashedPassword}" /> <br /><br />
  </body>
</html>
