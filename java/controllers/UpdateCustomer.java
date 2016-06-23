/*
 * UpdateCustomer
 * Simple redirect to customer list, with message instructing user to select a 
 * customer from the list to modify.
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
import model.system.*;

public class UpdateCustomer extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String role = null;
        String url = "Home";
        String message = null;
        String messageStyle = null;

        // Get role
        synchronized(session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        } // end synchronized

        if (role.equals("Manager") || role.equals("Account Specialist")) {
            url = "/ViewCustomers";
            message = "<strong>Attention: </strong>" 
                    + "Please select a customer to modify from the list below.";
            messageStyle = "warning";
        }

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

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