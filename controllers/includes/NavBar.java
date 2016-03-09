/* 
 * NavBar
 * 
 * Displays the appropriate nav bar for the user type.
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

import model.*;
import model.roles.*;

public class NavBar extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String role = null;
        String navbar;

        synchronized(session) {
            // Get user role
            role = (String) session.getAttribute("role");
        } // end synchronized

        // Set navbar based on role 
        if (role != null) {
            navbar = "/includes/nav-" 
                    + role.toLowerCase().replace(' ', '-') 
                    + ".jsp";
        } else {
            navbar = "/includes/nav-login.jsp";
        }

        request.getRequestDispatcher(navbar).include(request, response);
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}