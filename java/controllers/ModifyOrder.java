/*
 * ModifyOrder
 * GET, passed with orderId: Redirects to order modification form.
 * GET, passed without parameter: Redirects to orders list with message.
 * POST: Processes modify request.
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

public class ModifyOrder extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String role = null;
        String url = "Home";
        String orderId = request.getParameter("orderId");
        String message = null;
        String messageStyle = null;

        // Get role
        synchronized(session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        } // end synchronized

        if (role.equals("Manager")) {
            if (orderId != null) {
                url = "/modify-order.jsp";

                Order order = EntityData.getOrders().get(orderId);
                Customer customer = order.getCustomer();
                Item item = order.getItem();
                
                // Set attributes for order form
                request.setAttribute("orderId", orderId);
                request.setAttribute("customerName", customer.getFName() + " " 
                    + customer.getLName());
                request.setAttribute("itemName", item.getName());

            } else {
                url = "/ViewOrders";
                message = "<strong>Attention: </strong>" 
                        + "Please select an order to modify from the list below.";
                messageStyle = "warning";
            }
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
        
        HttpSession session = request.getSession();

        String role = null;
        String url = "Home";

        String orderId = request.getParameter("orderId");
        String itemId = request.getParameter("itemId");

        String message = null;
        String messageStyle = null;

        // Get role
        synchronized(session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        } // end synchronized

        if (role.equals("Manager")) {
            url = "/ViewOrders";
            message = EntityData.modifyOrder(orderId, itemId);
            messageStyle = 
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
        }        

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

        request.getRequestDispatcher(url).forward(request, response);
    }
}