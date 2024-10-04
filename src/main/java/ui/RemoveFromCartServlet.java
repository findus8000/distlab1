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

@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonValue = request.getParameter("action");
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        if(cart != null) {
            if(cart.containsKey(buttonValue)){
               int quantity = cart.get(buttonValue);
               if (quantity>1){
                   cart.put(buttonValue, quantity-1);
               }else{
                   cart.remove(buttonValue);
               }
            }
        }

        response.sendRedirect("home.jsp");

    }
}
