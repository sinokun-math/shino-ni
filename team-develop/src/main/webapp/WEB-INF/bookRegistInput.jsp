<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Registration</title>
</head>
<body>
    <h2>Book Registration</h2>
    <form action="bookRegistInput" method="post">
        <input type="hidden" name="id_book" value="${book.idBook}">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${book.isbn}"><br><br>
        <label for="nm_book">Book Name:</label>
        <input type="text" id="nm_book" name="nm_book" value="${book.nmBook}"><br><br>
        <label for="kn_book">Book Name (Kana):</label>
        <input type="text" id="kn_book" name="kn_book" value="${book.knBook}"><br><br>
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher" value="${book.publisher}"><br><br>
        <label for="note">Note:</label>
        <input type="text" id="note" name="note" value="${book.note}"><br><br>
        <button type="submit">Save</button>
    </form>
    <a href="bookList.jsp">Back to Book List</a>
</body>
</html>
