<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Update Confirm</title>
</head>
<body>
    <%
        String isbn = request.getParameter("isbn");
        String nmBook = request.getParameter("nm_book");
        String knBook = request.getParameter("kn_book");
        String publisher = request.getParameter("publisher");
        String note = request.getParameter("note");
    %>
    <h2>Book Update Confirm</h2>
    <form action="bookUpdate" method="post">
        <input type="hidden" name="id_book" value="${param.id_book}">
        <label>ISBN:</label>
        <input type="text" name="isbn" value="${isbn}" readonly><br><br>
        <label>Book Name:</label>
        <input type="text" name="nm_book" value="${nmBook}" readonly><br><br>
        <label>Book Name (Kana):</label>
        <input type="text" name="kn_book" value="${knBook}" readonly><br><br>
        <label>Publisher:</label>
        <input type="text" name="publisher" value="${publisher}" readonly><br><br>
        <label>Note:</label>
        <textarea name="note" readonly>${note}</textarea><br><br>
        <button type="submit">Update</button>
    </form>
    <form action="bookUpdateInput" method="get">
        <input type="hidden" name="id_book" value="${param.id_book}">
        <input type="hidden" name="isbn" value="${isbn}">
        <input type="hidden" name="nm_book" value="${nmBook}">
        <input type="hidden" name="kn_book" value="${knBook}">
        <input type="hidden" name="publisher" value="${publisher}">
        <input type="hidden" name="note" value="${note}">
        <button type="submit">Back to Input</button>
    </form>
</body>
</html>
