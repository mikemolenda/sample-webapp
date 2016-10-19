/*
 * AddTicket
 * GET: Displays add ticket form
 * POST: Adds ticket based on request info, redirects to ViewTickets
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

public class AddTicket extends HttpServlet {

    /**
     * Handle GET requests
     * User arrives via link
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String technicianId = request.getParameter("technicianId");

        String url = "/Home";
        String role = "";
        String username = "";

        synchronized(session) {

            // Get username and role
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
                username = (String) session.getAttribute("username");
            }

        } // end synchronized

        // If active user is a customer, use current id
        if (role.equals("Technician")) {
            request.setAttribute("technicianId", username);
            url = "/ticket-form.jsp";
        }

        // If user is manager or account admin, allow them to select technician id
        if (role.equals("Manager") || role.equals("Account Specialist")) {
            url = "/ticket-form.jsp";
        }

        // Redirect to appropriate URL
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handle POST requests
     * User submits info change
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String ticketMsg = request.getParameter("ticketMsg").trim();
        String customerId = request.getParameter("customerId");
        String technicianId = request.getParameter("technicianId");
        // Assume open will be true for new tickets
        // Assume schedule date will be today for new ticket

        // Truncate messages longer than 150 chars
        if (ticketMsg.length() > 150) {
            ticketMsg = ticketMsg.substring(0, 149);
        }

        String message;
        String messageStyle;
        String url = "/ViewTickets";
        String currentUser;

        // Add ticket
        Customer customer = (Customer) EntityData.getUsers().get(customerId);
        Technician technician =
            (Technician) EntityData.getUsers().get(technicianId);

        message = EntityData.addTicket(
            new Ticket(ticketMsg, customer, technician, true));

        messageStyle = message.matches(".*[Ss]uccess.*") ? "success" : "danger";

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

        request.getRequestDispatcher(url).forward(request, response);
    }
}
