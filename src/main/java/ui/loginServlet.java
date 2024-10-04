package ui;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import bo.CustomerHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get email and password from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String dbEmail = null;
        String dbPassword = null;

        Collection<CustomerInfo> result = CustomerHandler.getCustomersByEmail(email);
        for (CustomerInfo c : result) {
            dbEmail = c.getEmail();
            dbPassword = c.getPasswordHash();
        }

        if (dbEmail == null){
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (dbEmail.equals(email) && dbPassword.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    public void destroy() {
    }
}