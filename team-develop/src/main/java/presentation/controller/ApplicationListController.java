package presentation.controller;

import businesslogic.service.ApplicationService;
import businesslogic.model.BookCollectionBorrowBooksEmployee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
