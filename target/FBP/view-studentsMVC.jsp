<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Students</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    <c:forEach var="tempStudent" items="${studentList}">
        <tr>
            <td>${tempStudent.firstName} </td>
            <td>${tempStudent.lastName} </td>
            <td>${tempStudent.emailAddress} </td>
        </tr>
    </c:forEach>
    </table>
</html>