package kth.distlab1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    // Simulated in-memory storage for registered users
    private static final Map<String, String> userDatabase = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get username and password from the signup form
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        // Check if the username already exists
        if (userDatabase.containsKey(email)) {
            // If the username exists, set an error message and forward to signup.jsp
            request.setAttribute("errorMessage", "Username already exists. Please choose another.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        } else {
            // Register the new user
            userDatabase.put(email, password);
            response.sendRedirect("index.jsp");  // Redirect to login page after successful registration
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the signup page (signup.jsp) when accessing /register via GET
        response.sendRedirect("signup.jsp");
    }
}

