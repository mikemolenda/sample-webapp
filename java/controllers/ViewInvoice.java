/* 
 * ViewInvoice
 *
 * Displays user's bill. If passed with an itemId, adds item.
 * If passed with removeOrder, deletes order.
 * Can be accessed by a Customer whose username matches the invoice, or by any
 * Account Specialist or Manager.
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
        String removeOrder = request.getParameter("removeOrder");

        String url;
        User user = null;
        String role = "";
        Customer customer = null;
        String message = null;
        String messageStyle = null;

        synchronized(session) {

            // Get user and role
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
                role = user.getRole();
            }

        } // end synchronized

        // If active user is a customer, operate on active account
        if (role.equals("Customer")) {
            customer = (Customer) user;
        }

        // If user is manager or account admin, get customer based on reqest ID
        if (role.equals("Manager") || role.equals("Account Specialist")) {
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

        // Set URL and actions based on customer status
        if (customer != null) {
            // If user is customer or agent show invoice
            url = "/invoice.jsp";

            // If itemId passed, add order
            if (itemId != null) {
                Item item = EntityData.getItems().get(itemId);
                if (item != null) {
                    // Add order and get status message
                    message = EntityData.addOrder(new Order(item, customer));

                    messageStyle =
                        message.matches(".*[Ss]uccess.*") ? "success" : "danger";
                }
            }

            // If removeOrder passed, remove order
            if (removeOrder != null) {
                message = EntityData.removeOrder(removeOrder);
                messageStyle =
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }

            // Set attributes for view
            String customerName =
                customer.getFName() + " " + customer.getLName();
                request.setAttribute("message", message);
                request.setAttribute("messageStyle", messageStyle);
                request.setAttribute("customer", customer);
                request.setAttribute("customerName", customerName);

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
