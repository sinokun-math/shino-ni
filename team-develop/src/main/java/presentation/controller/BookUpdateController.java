package presentation.controller;

import businesslogic.model.BookCollection;
import businesslogic.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/bookUpdate")
public class BookUpdateController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idBook = request.getParameter("id_book");
        String isbn = request.getParameter("isbn");
        String nmBook = request.getParameter("nm_book");
        String knBook = request.getParameter("kn_book");
        String publisher = request.getParameter("publisher");
        String note = request.getParameter("note");
        char flgLending = 'N'; // Assume default value
        int idUpdate = 1; // Assume default value
        Timestamp dateUpdate = new Timestamp(System.currentTimeMillis());

        BookCollection book = new BookCollection(
            Integer.parseInt(idBook),
            isbn, nmBook, knBook, publisher, note, flgLending, idUpdate, dateUpdate
        );

        bookService.updateBook(book);
        request.getRequestDispatcher("bookUpdateComplete.jsp").forward(request, response);
    }
}
