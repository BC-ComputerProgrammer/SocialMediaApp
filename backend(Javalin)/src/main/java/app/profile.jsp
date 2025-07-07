<%@ page import="com.yourpackage.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.html"); // Force login if no session
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Welcome, <%= user.getUsername() %>!</h1>
    <p>Email: <%= user.getEmail() %></p>
    <!-- Add other user details -->
    <a href="logout">Logout</a> <!-- Link to your LogoutServlet -->
</body>
</html>
