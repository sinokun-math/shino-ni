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

@WebServlet("/bookRegistInput")
public class BookRegistInputController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idBook = request.getParameter("id");
        if (idBook != null) {
            BookCollection book = bookService.getBookById(Integer.parseInt(idBook));
            request.setAttribute("book", book);
        }
        request.getRequestDispatcher("bookRegistInput.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idBook = request.getParameter("id_book");
        String isbn = request.getParameter("isbn");
        String nmBook = request.getParameter("nm_book");
        String knBook = request.getParameter("kn_book");
        String publisher = request.getParameter("publisher");
        String note = request.getParameter("note");
        char flgLending = request.getParameter("flg_lending").charAt(0);
        int idUpdate = Integer.parseInt(request.getParameter("id_update"));
        Timestamp dateUpdate = Timestamp.valueOf(request.getParameter("date_update"));

        BookCollection book = new BookCollection(
            idBook != null && !idBook.isEmpty() ? Integer.parseInt(idBook) : null,
            isbn, nmBook, knBook, publisher, note, flgLending, idUpdate, dateUpdate
        );
        
        if (idBook == null || idBook.isEmpty()) {
            bookService.registerBook(book);
        } else {
            bookService.updateBook(book);
        }
        
        response.sendRedirect("bookList");
    }
}
