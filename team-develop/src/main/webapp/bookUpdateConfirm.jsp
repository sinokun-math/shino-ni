<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="businesslogic.model.BookCollection" %>
<%@ page import="presentation.form.LoginUserForm" %>
<%@ page import="businesslogic.model.LoginUser" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
    <%
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        LoginUserForm loginUserForm = LoginUserForm.convertFrom(loginUser);
        List<BookCollection> bookList = (List<BookCollection>) request.getAttribute("bookList");
    %>
    <h2>Book List</h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <form action="bookList" method="get">
        <label for="nm_book">Book Name:</label>
        <input type="text" id="nm_book" name="nm_book"><br><br>
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher"><br><br>
        <label for="note">Note:</label>
        <input type="text" id="note" name="note"><br><br>
        <button type="submit">Search</button>
    </form>
    <br>
    <a href="menu.jsp">Back to Menu</a>
    <h2>Search Results</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>Book Name</th>
                <th>Book Name (Kana)</th>
                <th>Publisher</th>
                <th>Note</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% if (bookList != null) {
                for (BookCollection book : bookList) { %>
                    <tr>
                        <td><%= book.getIdBook() %></td>
                        <td><%= book.getIsbn() %></td>
                        <td><%= book.getNmBook() %></td>
                        <td><%= book.getKnBook() %></td>
                        <td><%= book.getPublisher() %></td>
                        <td><%= book.getNote() %></td>
                        <td>
                            <form action="applicationInput" method="post" style="display:inline;">
                                <input type="hidden" name="id_book" value="<%= book.getIdBook() %>">
                                <button type="submit">Apply for Borrow</button>
                            </form>
                            <% if (loginUserForm.isAdmin()) { %>
                                <form action="bookUpdateInput" method="get" style="display:inline;">
                                    <input type="hidden" name="id_book" value="<%= book.getIdBook() %>">
                                    <button type="submit">Edit</button>
                                </form>
                            <% } %>
                        </td>
                    </tr>
            <% }
            } %>
        </tbody>
    </table>
</body>
</html>
