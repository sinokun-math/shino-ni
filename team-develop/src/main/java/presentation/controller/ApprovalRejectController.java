package presentation.controller;

import businesslogic.service.ApplicationService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/rejectApplication")
public class ApprovalRejectController extends HttpServlet {

    private ApplicationService applicationService = new ApplicationService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRequest = Integer.parseInt(request.getParameter("id_request"));
        int idEmployee = ((LoginUser) request.getSession().getAttribute("loginUser")).getEmployee().getIdEmployee();

        applicationService.rejectApplication(idRequest, idEmployee, new Timestamp(System.currentTimeMillis()));

        request.getRequestDispatcher("approvalRejected.jsp").forward(request, response);
    }
}
