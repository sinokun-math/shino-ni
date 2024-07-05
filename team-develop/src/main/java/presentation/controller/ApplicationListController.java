package presentation.controller;

import businesslogic.service.ApplicationService;
import businesslogic.model.BookCollectionBorrowBooksEmployee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/applicationList")
public class ApplicationListController extends HttpServlet {

    private ApplicationService applicationService = new ApplicationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookCollectionBorrowBooksEmployee> applicationList = applicationService.getAllApplications();
        request.setAttribute("applicationList", applicationList);
        request.getRequestDispatcher("applicationList.jsp").forward(request, response);
    }
}
