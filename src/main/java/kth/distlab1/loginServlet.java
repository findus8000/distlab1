package kth.distlab1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class loginServlet extends HttpServlet {
    private static final String Email = "admin";
    private static final String PASSWORD = "password123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get email and password from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate the credentials
        if (Email.equals(email) && PASSWORD.equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("email", email);  // Store email in the session
            response.sendRedirect("home.jsp");  // Redirect to home page
        } else {
            // Failed login: set an error attribute and forward back to index.jsp
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the login page (index.jsp) when accessing /hello via GET
        response.sendRedirect(request.getContextPath() + "/");
    }*/

    public void destroy() {
    }
}