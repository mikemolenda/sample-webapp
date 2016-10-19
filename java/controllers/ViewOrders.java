/* 
 * ViewOrders
 *
 * Displays all active orders.
 * Removes order if removeOrder attribute passed.
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

public class ViewOrders extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String role = null;
        String url = "Home";

        String removeOrder = request.getParameter("removeOrder");

        String message = (String) request.getAttribute("message");
        String messageStyle = (String) request.getAttribute("messageStyle");

        // Get role
        synchronized (session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        }

        // Only managers and admins can view all orders
        if (role.equals("Manager") || role.equals("Account Specialist")) {
            url = "/order-list.jsp";
        }

        // If passed with removeOrder, remove that order
        if (removeOrder != null) {
            message = EntityData.removeOrder(removeOrder, role);
            messageStyle =
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
        }

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Handle POST requests
     * User submits info change
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
