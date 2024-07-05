package presentation.controller;

import businesslogic.model.BookCollection;
import businesslogic.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/applicationInput")
public class ApplicationInputController extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("id_book"));
        BookCollection book = bookService.getBookById(idBook);
        request.setAttribute("book", book);
        request.getRequestDispatcher("application.jsp").forward(request, response);
    }
}
