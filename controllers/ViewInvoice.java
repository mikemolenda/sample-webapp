/* 
 * ViewInvoice
 * 
 * Displays user's bill. If passed with an itemId, adds item. 
 * If passed with removeOrder, deletes order.
 * Can be accessed by a Customer whose username matches the invoice, or by any 
 * Account Specialist or Manager.
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

package controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;
import model.items.*;
import model.system.*;

public class ViewInvoice extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String customerId = request.getParameter("customerId");
        String itemId = request.getParameter("itemId");

        String url;
        Customer customer = null;

        synchronized(session) {

            // Get customer
            if (session.getAttribute("user") != null) {

                // Get user role
                User user = (User) session.getAttribute("user");
                String role = user.getRole();

                // If active user is a customer, operate on active account
                if (role.equals("Customer")) {
                    customer = (Customer) user;
                }

                // If manager or account admin, get customer from reqest ID
                if (role.equals("Manager") || 
                    role.equals("Account Specialist")) {

                    // If customerId specified, get customer from Hashmap
                    if (customerId != null) {

                        User targetUser = EntityData.getUsers().get(customerId);
                        
                        // Ensure customer is actually a customer
                        if (targetUser != null 
                            && targetUser.getRole().equals("Customer")) {
                            customer = (Customer) targetUser; 
                        }
                    }
                }
            }

        } // end synchronized

        if (customer != null) {

            url = "/invoice.jsp";

            // If itemId passed, add order
            if (itemId != null) {
                Item item = EntityData.getItems().get(itemId);
                if (item != null) {
                    // Add order and get status message
                    String addOrder = 
                        EntityData.addOrder(new Order(item, customer));
                    request.setAttribute("addOrder", addOrder);
                }
            }

            // If orderId passed, remove order

        } else {
            // If user is not customer or customer agent, redirect home
            url = "/Home";
        }

        // Redirect to appropriate URL
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