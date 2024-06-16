package presentation.controller;

import businesslogic.model.BookCollectionBorrowBooksEmployee;
import presentation.form.ApplicationForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/approvalConfirm")
public class ApprovalConfirmController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationForm applicationForm = new ApplicationForm(
            Integer.parseInt(request.getParameter("id_request")),
            request.getParameter("nm_employee"),
            request.getParameter("isbn"),
            request.getParameter("nm_book"),
            request.getParameter("publisher"),
            request.getParameter("note"),
            request.getParameter("date_borrow"),
            request.getParameter("date_scheduled_return")
        );

        request.setAttribute("application", applicationForm);
        request.getRequestDispatcher("approvalConfirm.jsp").forward(request, response);
    }
}
