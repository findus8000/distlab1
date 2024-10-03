package ui;


import bo.CustomerHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get username and password from the signup form
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        CustomerInfo customer = new CustomerInfo(-1,password,"",email,lastName,firstName);
        // Check if the username already exists
        try {
            if (CustomerHandler.addCustomer(customer)) {
                // If the username exists, set an error message and forward to signup.jsp
                response.sendRedirect("login.jsp");

            } else {
                request.setAttribute("errorMessage", "Username already exists. Please choose another.");
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the signup page (signup.jsp) when accessing /register via GET
        response.sendRedirect("signup.jsp");
    }
}

