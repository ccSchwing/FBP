<!DOCTYPE html>
<html lang="en">
<head>
<title>Student Registration Form</title>
</head>
<body>
 <%
    String servletPath = request.getContextPath() + "/StudentServlet";
%>

  <form action="<%=servletPath%>" method="POST">
    First name: <input type="text" name="firstName" />
    
    <br/><br/>
    
    Last name: <input type="text" name="lastName" />
    
    <br/><br/>

    Favorite Programming Language: <br/>
    
    <input type="checkbox" name="favoriteLanguage" value="Java"> Java

    <input type="checkbox" name="favoriteLanguage" value="C#"> C#

    <input type="checkbox" name="favoriteLanguage" value="PHP"> PHP

    <input type="checkbox" name="favoriteLanguage" value="Ruby"> Ruby
    
    <br/><br/>
    
    <input type="submit" value="Go!" />
</html>