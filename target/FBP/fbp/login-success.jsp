<!DOCTYPE html>
<html>
  <head>
    <title>FBP Login Successful</title>
  </head>

  <body>
    <p>Foo!</p>
    <br /><br />
 	<% String Success = (String) request.getAttribute("Success");
	   if (Success != null) { %>
	   <div style="color: green;"><b><%= Success %></b></div>
	<% } %>
  </body>
</html>
