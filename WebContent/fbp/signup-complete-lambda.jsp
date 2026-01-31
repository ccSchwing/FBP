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
  </body>
</html>
