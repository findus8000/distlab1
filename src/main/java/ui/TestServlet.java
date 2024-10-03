package ui;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "testServlet", value = "/test-servlet")
public class TestServlet extends HttpServlet {
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        counter++;


        request.setAttribute("counter", counter);


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}