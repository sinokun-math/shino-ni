<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="presentation.form.LoginUserForm" %>
<%@ page import="businesslogic.model.LoginUser" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
    <%
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        LoginUserForm loginUserForm = LoginUserForm.convertFrom(loginUser);
    %>
    <h2>Welcome, <%= loginUserForm.getMailAddress() %></h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <br><br>
    <button onclick="location.href='bookList'">書籍一覧</button>
    <% if (loginUserForm.isAdmin()) { %>
        <button onclick="location.href='applicationList'">書籍貸出申請一覧</button>
    <% } %>
</body>
</html>
