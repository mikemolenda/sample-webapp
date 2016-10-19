/*
 * AddOrder
 * GET: Displays add order form
 * POST: Adds order to HashMap, displays confirmation
 * Only available to admins and managers.
 * Admins can only add PPVs
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

public class AddOrder extends HttpServlet {

    /**
     * Handle GET requests
     * User arrives via link
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String role = null;
        String url = "Home";

        // Get role
        synchronized(session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        } // end synchronized

        if (role.equals("Manager") || role.equals("Account Specialist")) {
            url = "/add-order.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handle POST requests
     * User submits info change
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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

        String customerId = request.getParameter("customerId");
        String itemId = request.getParameter("itemId");

        Customer customer = null;
        Item item = null;

        if (customerId != null && itemId != null) {
            customer = (Customer) EntityData.getUsers().get(customerId);
            item = EntityData.getItems().get(itemId);
        }

        if (customer != null && item != null) {
            url = "ViewOrders";

            // Account admins can only add PPV
            if (role.equals("Account Specialist")) {
                if (item.getCategory().matches(".*PPV.*")) {
                    message = EntityData.addOrder(new Order(item, customer));
                    messageStyle =
                        message.matches(".*[Ss]uccess.*") ? "success" : "danger";
                } else {
                    message = "Not authorized to add " + item.getCategory();
                    messageStyle = "danger";
                }
            }

            // Managers can add any item type
            if (role.equals("Manager")) {
                message = EntityData.addOrder(new Order(item, customer));
                messageStyle =
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }
        }

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

        request.getRequestDispatcher(url).forward(request, response);
    }
}
