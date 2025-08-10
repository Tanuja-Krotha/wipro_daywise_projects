<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>

    <form:form method="post" action="register" modelAttribute="user">
        Username: <form:input path="username"/><br><br>
        Email: <form:input path="userEmail"/><br><br>
        Phone: <form:input path="userPhone"/><br><br>
        <input type="submit" value="Register"/>
    </form:form>

</body>
</html>
