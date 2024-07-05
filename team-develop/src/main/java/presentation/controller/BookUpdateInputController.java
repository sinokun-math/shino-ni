package presentation.controller;

import businesslogic.model.BookCollection;
import businesslogic.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookUpdateInput")
public class BookUpdateInputController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idBook = request.getParameter("id_book");
        if (idBook != null) {
            BookCollection book = bookService.getBookById(Integer.parseInt(idBook));
            request.setAttribute("book", book);
        }
        request.getRequestDispatcher("bookUpdateInput.jsp").forward(request, response);
    }
}
