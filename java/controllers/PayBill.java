/* 
 * PayBill
 *
 * "Pays" the user's outstanding invoice:
 * Clears the invoice and displays a confirmation message.
 */

package controllers;

import java.io.*;
import java.math.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;
import model.items.*;
import model.system.*;

public class PayBill extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url;
        Customer customer = null;
        String role = "";
        boolean success;

        synchronized(session) {

            // Get user and role
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
                if (role.equals("Customer")) {
                    customer = (Customer) session.getAttribute("user");
                }
            }

        } // end synchronized

        if (customer != null) {
            // Store total
            BigDecimal total = EntityData.calculateOrderTotal(customer);
            request.setAttribute("total", total.toString());

            // Get credit card verification number
            String ccLast4 = customer.getCCLast4();
            request.setAttribute("ccLast4", ccLast4);

            // Clear customer's open orders
            EntityData.clearOrders(customer);

            // Check if remove successful
            success = (!EntityData.hasOrders(customer));
        } else {
            // If customer null, remove could not be successful
            success = false;
        }

        if (success) {
            url = "/payment-confirmation.jsp";
        } else {
            url = "/payment-failure.jsp";
        }

        // Redirect to appropriate URL
        request.getRequestDispatcher(url).forward(request, response);
    }
}
