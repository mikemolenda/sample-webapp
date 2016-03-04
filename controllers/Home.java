/* 
 * Home
 * 
 * Controls the home page displayed to the user, based on their role
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

package controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class Home extends HttpServlet {

    // Mapping of urls for each specific role
    private static Map<String, String> urlMap = new HashMap<String, String>() {{
        put("Customer", "/index-customer.jsp");
        put("Manager", "/index-manager.jsp");
        put("Account Specialist", "/index-account-specialist.jsp");
        put("Technician", "/index-account-specialist.jsp");
    }};

    /**
     * Handle GET requests (e.g. from URL)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RequestDispatcher rd;

        User user;
        String role;
        String url;

        synchronized(session) {

            if (session.getAttribute("user") == null) {
                // If session user null, set role to None
                role = "None";
                if (session.getAttribute("login") == null) {
                    // If login null, set to none
                    session.setAttribute("login", "none");
                }
            } else {
                // Otherwise set role to session user role
                user = (User) session.getAttribute("user");
                role = user.getRole();
            }

        } // end synchronized

        // Set page title and url based on mapping
        if (urlMap.get(role) == null) {
            url = "/login.jsp";
        } else {
            url = urlMap.get(role);
        }

        // Forward to appropriate home page for user
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     * Handle POST requests (e.g. from Login)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}