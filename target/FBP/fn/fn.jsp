<!DOCTYPE html>

<html lang="en">
	<head>
		<title>JSP Functions</title>
	</head>
	<body>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <h1>JSP Functions Example</h1>
        <p>Original String: "  Hello, JSP Functions!  "</p>
        <p>Trimmed String: "${fn:trim('  Hello, JSP Functions!  ')}"</p>
        <p>String Length: "${fn:length('Hello, JSP Functions!')}"</p>
        <p>Uppercase String: "${fn:toUpperCase('hello, jsp functions!')}"</p>
        <p>Lowercase String: "${fn:toLowerCase('HELLO, JSP FUNCTIONS!')}"</p>
	</body>
</html>