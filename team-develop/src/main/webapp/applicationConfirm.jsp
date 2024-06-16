<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="presentation.form.ApplicationForm" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Approval Confirmation</title>
</head>
<body>
    <h2>Approval Confirmation</h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <%
        ApplicationForm application = (ApplicationForm) request.getAttribute("application");
    %>
    <form action="approveApplication" method="post">
        <label>Request ID:</label>
        <input type="text" name="id_request" value="<%= application.getIdRequest() %>" readonly><br><br>
        <label>Applicant Name:</label>
        <input type="text" name="nm_employee" value="<%= application.getNmEmployee() %>" readonly><br><br>
        <label>ISBN:</label>
        <input type="text" name="isbn" value="<%= application.getIsbn() %>" readonly><br><br>
        <label>Book Name:</label>
        <input type="text" name="nm_book" value="<%= application.getNmBook() %>" readonly><br><br>
        <label>Publisher:</label>
        <input type="text" name="publisher" value="<%= application.getPublisher() %>" readonly><br><br>
        <label>Note:</label>
        <textarea name="note" readonly><%= application.getNote() %></textarea><br><br>
        <label>Borrow Date:</label>
        <input type="text" name="date_borrow" value="<%= application.getDateBorrow() %>" readonly><br><br>
        <label>Scheduled Return Date:</label>
        <input type="text" name="date_scheduled_return" value="<%= application.getDateScheduledReturn() %>" readonly><br><br>
        <button type="submit">Approve</button>
    </form>
    <form action="applicationList" method="get">
        <button type="submit">Back to List</button>
    </form>
</body>
</html>
