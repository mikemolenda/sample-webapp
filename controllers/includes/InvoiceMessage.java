/* 
 * InvoiceMessage
 * 
 * Displays the status message returned by add/remove order actions.
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
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InvoiceMessage extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String message = (String) request.getAttribute("invoiceMessage");

        if (message != null) {
            String url = "includes/alert-invoice.jsp";
            
            if (message.equals("Success!")) {
                request.setAttribute("alertStyle", "alert alert-success");
            } else {
                request.setAttribute("alertStyle", "alert alert-danger");
            }

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