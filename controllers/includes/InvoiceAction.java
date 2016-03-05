/* 
 * InvoiceAction
 * 
 * Displays an action button for user, depending on role.
 * Customers get a "Pay Bill" button.
 * Admins get a "View Different Invoice" button.
 * 
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2017
 * Final Project
 *
 * March 13, 2016
 *
 * Mike Molenda
 * michaelmolenda2014@u.northwestern.edu 
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
        String total = (String) request.getAttribute("total");
        String action = null;
        String url = "/includes/action-button.jsp";
        String btntext = "Submit";

        synchronized (session) {

            if (session.getAttribute("user") != null) {

                // Get user role
                User user = (User) session.getAttribute("user");
                String role = user.getRole();

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
            }
        } // end synchronized

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