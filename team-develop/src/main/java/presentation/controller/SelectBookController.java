package presentation.controller;

import businesslogic.service.BookService;
import businesslogic.model.BookCollection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectBook")
public class SelectBookController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nmBook = request.getParameter("nm_book");
        String publisher = request.getParameter("publisher");
        String note = request.getParameter("note");

        List<BookCollection> bookList = bookService.searchBooks(nmBook, publisher, note);
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}
