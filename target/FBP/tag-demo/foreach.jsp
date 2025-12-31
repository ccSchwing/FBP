<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Tag Plugin Examples: forEach</title>
  </head>
  <body>
    <h1>Tag Plugin Examples - &lt;c:forEach></h1>

    <hr/>
    <br/>
    <a href="notes.html">Plugin Introductory Notes</a>
    <br/>
    <a href="howto.html">Brief Instructions for Writing Plugins</a>
    <br/> <br/>
    <hr/>

    <br/>

    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page import="java.util.Vector" %>

    <h3>Iterating over a range</h3>
    <c:forEach var="item" begin="1" end="10">
        ${item} 
    </c:forEach>

    <% Vector<String> v = new Vector<>();
        v.add("One"); v.add("Two"); v.add("Three"); v.add("Four");

        pageContext.setAttribute("vector", v);
    %>

    <h3>Iterating over a Vector</h3>

    <c:forEach items="${vector}" var="item" >
        ${item}
    </c:forEach>
  </body>
</html>