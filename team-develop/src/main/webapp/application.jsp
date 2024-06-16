<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="businesslogic.model.BookCollection" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Borrow Application</title>
</head>
<body>
    <%
        BookCollection book = (BookCollection) request.getAttribute("book");
    %>
    <h2>Book Borrow Application</h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <form action="applicationConfirm" method="post">
        <label for="id_book">Book ID:</label>
        <input type="text" id="id_book" name="id_book" value="<%= book.getIdBook() %>" readonly><br><br>
        <label for="nm_book">Book Name:</label>
        <input type="text" id="nm_book" name="nm_book" value="<%= book.getNmBook() %>" readonly><br><br>
        <label for="date_borrow">Borrow Date:</label>
        <input type="date" id="date_borrow" name="date_borrow" required><br><br>
        <label for="date_scheduled_return">Scheduled Return Date:</label>
        <input type="date" id="date_scheduled_return" name="date_scheduled_return" required><br><br>
        <button type="submit">Confirm</button>
    </form>
    <a href="bookList">Back to Book List</a>
</body>
</html>
