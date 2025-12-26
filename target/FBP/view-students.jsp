<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Students</title>
</head>
<body>
    <c:forEach var="tempStudent" items="${studentList}">
            ${tempStudent} <br />
    </c:forEach>
</html>