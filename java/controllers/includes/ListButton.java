/* 
 * ListButton
 * 
 * Displays a "Return to Customer List" button for managers and admins.
 * 
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2016
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

public class ListButton extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String role = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get role
        synchronized (session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        }

        // If role manager or admin, print button
        if (role.equals("Manager") || role.equals("Account Specialist")) {
            out.println("&nbsp;");
            out.println("<a href=\"ViewCustomers\" class=\"btn btn-info\">" 
                + "Return to Customer List</a>");
        }

        // Do not close output stream, control returns to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}