<!DOCTYPE html>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page
import="java.security.MessageDigest" %> <%@ page
import="com.planb.utils.FBPUtils"
%>

<html>
  <head>
    <title>FBP Registration</title>
  </head>

  <body>
	<% String errorMessage = (String) request.getAttribute("errorMessage");
	   if (errorMessage != null) { %>
	   <div style="color: red;"><b><%= errorMessage %></b></div>
	<% } %>
    <form id="order" action="process-order.jsp" method="post">
      <br /><br />

      Item Id: <input type="number" name="id">

      Item Name: <input type="text" name="itemName" />

      Quantity: <input type="number" name="quantity" />

      <button type="submit"> Submit </button>
    </form>
    <br /><br />

  </body>
</html>
