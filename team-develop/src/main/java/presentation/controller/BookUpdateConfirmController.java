package presentation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookUpdateConfirm")
public class BookUpdateConfirmController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Confirm data from input form and set them as attributes to be displayed in confirm page
        request.setAttribute("id_book", request.getParameter("id_book"));
        request.setAttribute("isbn", request.getParameter("isbn"));
        request.setAttribute("nm_book", request.getParameter("nm_book"));
        request.setAttribute("kn_book", request.getParameter("kn_book"));
        request.setAttribute("publisher", request.getParameter("publisher"));
        request.setAttribute("note", request.getParameter("note"));

        request.getRequestDispatcher("bookUpdateConfirm.jsp").forward(request, response);
    }
}
