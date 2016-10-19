/* 
 * InvoiceAction
 * 
 * Displays an action button for user, depending on role.
 * Customers get a "Pay Bill" button.
 * Admins get a "View Different Invoice" button.
 * 


 
 *
 
 *
 
 
 */

package controllers.includes;

import java.io.*;
import java.math.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class InvoiceAction extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String role = null;

        Customer customer = (Customer) request.getAttribute("customer");
        BigDecimal total = EntityData.calculateOrderTotal(customer);
        
        String action = null;
        String url = "/includes/action-button.jsp";
        String btntext = "Submit";

        synchronized (session) {
            // Get user role
            role = (String) session.getAttribute("role");
        } // end synchronized

        // Set action based on user type
        if (role.equals("Customer")) {
            action = "PayBill";
            btntext = "Pay Bill $" + total;
        }
        
        if (role.equals("Manager") || 
            role.equals("Account Specialist")) {
            action = "";
            btntext = "View Different Invoice";
        }

        if (action != null) {         
            request.setAttribute("action", action);
            request.setAttribute("btntext", btntext);
            
            request.getRequestDispatcher(url).include(request, response);
        }        
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}