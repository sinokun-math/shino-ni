<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="businesslogic.model.BookCollectionBorrowBooksEmployee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application List</title>
</head>
<body>
    <h2>Application List</h2>
    <button style="float: right;" onclick="location.href='logout'">Logout</button>
    <a href="menu.jsp">Back to Menu</a>
    <h2>Search Results</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Applicant Name</th>
                <th>Book Name</th>
                <th>Borrow Date</th>
                <th>Scheduled Return Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<BookCollectionBorrowBooksEmployee> applicationList = (List<BookCollectionBorrowBooksEmployee>) request.getAttribute("applicationList");
                if (applicationList != null) {
                    for (BookCollectionBorrowBooksEmployee application : applicationList) { 
            %>
                <tr>
                    <td><%= application.getNmEmployee() %></td>
                    <td><%= application.getNmBook() %></td>
                    <td><%= application.getDateBorrow() %></td>
                    <td><%= application.getDateScheduledReturn() %></td>
                    <td>
                        <form action="approvalConfirm" method="post" style="display:inline;">
                            <input type="hidden" name="id_request" value="<%= application.getIdRequest() %>">
                            <input type="hidden" name="nm_employee" value="<%= application.getNmEmployee() %>">
                            <input type="hidden" name="isbn" value="<%= application.getIsbn() %>">
                            <input type="hidden" name="nm_book" value="<%= application.getNmBook() %>">
                            <input type="hidden" name="publisher" value="<%= application.getPublisher() %>">
                            <input type="hidden" name="note" value="<%= application.getNote() %>">
                            <input type="hidden" name="date_borrow" value="<%= application.getDateBorrow() %>">
                            <input type="hidden" name="date_scheduled_return" value="<%= application.getDateScheduledReturn() %>">
                            <button type="submit">Approve</button>
                        </form>
                    </td>
                </tr>
            <% 
                    }
                } 
            %>
        </tbody>
    </table>
</body>
</html>
