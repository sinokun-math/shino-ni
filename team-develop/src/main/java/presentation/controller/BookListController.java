package presentation.controller;

import businesslogic.model.BookCollection;
import businesslogic.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {

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
