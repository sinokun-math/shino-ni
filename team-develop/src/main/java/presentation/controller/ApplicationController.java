package presentation.controller;

import businesslogic.model.BorrowBooks;
import businesslogic.service.BorrowBooksService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/applicationComplete")
public class ApplicationController extends HttpServlet {

    private BorrowBooksService borrowBooksService = new BorrowBooksService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("id_book"));
        String nmBook = request.getParameter("nm_book");
        Date dateBorrow = Date.valueOf(request.getParameter("date_borrow"));
        Date dateScheduledReturn = Date.valueOf(request.getParameter("date_scheduled_return"));

        BorrowBooks borrowBooks = new BorrowBooks(
            0, // autoincrement field, will be set by the database
            1, // assume logged-in user ID
            idBook,
            new Date(System.currentTimeMillis()), // current date as request date
            'P', // status 'P' for pending
            null, // approval ID
            null, // approval date
            dateBorrow,
            dateScheduledReturn,
            null, // return date
            1, // update ID
            new java.sql.Timestamp(System.currentTimeMillis()) // current timestamp
        );

        borrowBooksService.applyForBorrow(borrowBooks);

        request.getRequestDispatcher("applicationComplete.jsp").forward(request, response);
    }
}
