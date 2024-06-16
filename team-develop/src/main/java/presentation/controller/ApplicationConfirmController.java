package presentation.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/applicationConfirm")
public class ApplicationConfirmController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_book", request.getParameter("id_book"));
        request.setAttribute("nm_book", request.getParameter("nm_book"));
        request.setAttribute("date_borrow", request.getParameter("date_borrow"));
        request.setAttribute("date_scheduled_return", request.getParameter("date_scheduled_return"));
        request.getRequestDispatcher("applicationConfirm.jsp").forward(request, response);
    }
}
