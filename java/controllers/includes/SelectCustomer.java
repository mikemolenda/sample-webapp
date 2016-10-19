/* 
 * SelectCustomer
 * 
 * Displays a dropdown from which to select customers, or a hidden field 
 * containing a customer ID if requested with a customerID attribute.
 * 


 
 *
 
 *
 
 
 */

package controllers.includes;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class SelectCustomer extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String customerId = (String) request.getAttribute("customerId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (customerId != null) {
            // Include hidden field with customer ID baked in
            out.println("<input type=\"hidden\" name=\"customerId\" "
                + "value=\"" + customerId + "\">");
        } else {
            // Include dropdown field listing all customers
            out.println("<label for=\"customerId\">Customer: </label>");
            out.println("<select name=\"customerId\" class=\"form-control\">");

            for (Entry<String, User> entry : EntityData.getUsers().entrySet()) {
                User user = entry.getValue();

                if (user.getRole().equals("Customer")) {
                    // Add username and full name to select list
                    String value = user.getUsername();
                    String display = user.getLName() + ", " + user.getFName();

                    out.println("<option value=\"" + value + "\">" 
                        + display + " (" + value + ")</option>");
                }
            }

            out.println("</select>");
        }

        // Don't close output stream, control transfers back to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}