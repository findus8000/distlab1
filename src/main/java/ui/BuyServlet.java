package ui;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/submitBuy")
public class BuyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonValue = request.getParameter("action");


        if (buttonValue != null) {
            HttpSession session = request.getSession();

            HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

            if(cart == null) {
                cart = new HashMap<>();
                cart.put(buttonValue, 1);
                session.setAttribute("cart", cart);
            }else{

                if (cart.get(buttonValue) == null){
                    cart.put(buttonValue, 1);
                }else {
                    cart.put(buttonValue, cart.get(buttonValue) + 1);
                }

                session.setAttribute("cart", cart);
            }

            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessageBuy", "Error adding to cart.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}
