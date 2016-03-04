/* 
 * TVPlans
 * 
 * Controls the TV Plans page displayed to the user.
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
import model.items.*;

public class ItemList extends HttpServlet {

    /**
     * Handle GET requests (e.g. from URL)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String category = request.getParameter("category");

        String url;
        String imgSplash;

        synchronized(session) {

            // Get user role
            if (session.getAttribute("user") != null) {

                User user = (User) session.getAttribute("user");
                String role = user.getRole();

                // If user is not a customer, get out of here
                if (role.equals("Customer")) {
                    url = "/item-list.jsp";
                } else {
                    url = "/Home";
                }
            } else {
                url = "/Home";
            }

        } // end synchronized

        // Set request parameters based on category
        if (category != null) {
            imgSplash = category.toLowerCase().replace(' ', '-');
        } else {
            imgSplash = "main";
        }

        // Forward to appropriate page for request
        request.setAttribute("imgSplash", imgSplash);
        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}