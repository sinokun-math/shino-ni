package presentation.controller;

import businesslogic.model.LoginInfo;
import businesslogic.model.LoginUser;
import businesslogic.service.Login;
import presentation.form.LoginUserForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private Login loginService = new Login();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mailAddress = request.getParameter("mail_address");
        String password = request.getParameter("password");

        LoginInfo loginInfo = new LoginInfo(mailAddress, password);
        LoginUser loginUser = loginService.authenticate(loginInfo);

        if (loginUser != null) {
            request.getSession().setAttribute("loginUser", loginUser);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
