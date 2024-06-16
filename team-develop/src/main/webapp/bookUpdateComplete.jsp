<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="presentation.form.LoginUserForm" %>
<%@ page import="businesslogic.model.LoginUser" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Update Complete</title>
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
    <h2>Book Update Complete</h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <h2>書籍編集が完了しました</h2>
    <div>
        <a href="bookList.jsp">書籍一覧に戻る</a> |
        <a href="menu.jsp">メニューに戻る</a>
    </div>
</body>
</html>
