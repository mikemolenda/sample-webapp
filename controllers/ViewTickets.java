/* 
 * ViewTickets
 * 
 * Displays technician's tickets. If passed with cancelTicket parameter, 
 * deletes ticket. If passed with completeTicket parameter, changes the ticket's 
 * status to closed.
 * Can be accessed by a Technician whose username matches the tickets, or by any 
 * Account Specialist or Manager.
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

public class ViewTickets extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String technicianId = request.getParameter("technicianId");
        String cancelTicket = request.getParameter("cancelTicket");
        String completeTicket = request.getParameter("completeTicket");
        String status = request.getParameter("status");

        String url = "/Home";  // redirect home by default
        User user = null;
        String role = "";
        Technician technician = null;
        String message = (String) request.getAttribute("message");
        String messageStyle = (String) request.getAttribute("messageStyle");

        synchronized(session) {

            // Get user and role
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
                role = user.getRole();
            }

        } // end synchronized

        // Technician role actions
        if (role.equals("Technician")) {
            url = "/tickets.jsp";
            technician = (Technician) user;

            // If cancelTicket passed, cancel ticket (using overloaded method)
            if (cancelTicket != null) {
                message = EntityData.cancelTicket(cancelTicket, technician);
                messageStyle = 
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }

            // If completeTicket passed, completeTicket (using overloaded method)
            if (completeTicket != null) {
                message = EntityData.completeTicket(completeTicket, technician);
                messageStyle = 
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }
        }

        // If user is manager, view all tickets, allow cancel/complete
        if (role.equals("Manager") || role.equals("Account Specialist")) {
            
            url = "/tickets.jsp";

            // If technicianId specified, get technician from Hashmap
            if (technicianId != null) {
                User targetUser = EntityData.getUsers().get(technicianId);            
                
                // Ensure technician is actually a technician
                if (targetUser != null 
                        && targetUser.getRole().equals("Technician")) {
                    technician = (Technician) targetUser; 
                }
            }

            // If cancelTicket passed, cancel ticket
            if (cancelTicket != null) {
                message = EntityData.cancelTicket(cancelTicket);
                messageStyle = 
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }

            // If completeTicket passed, completeTicket
            if (completeTicket != null) {
                message = EntityData.completeTicket(completeTicket);
                messageStyle = 
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
            }
        }

        // If user is admin, 

        // Set technician attributes for view
        if (technician != null) {
            String technicianName = 
                technician.getFName() + " " + technician.getLName();
            request.setAttribute("technician", technician);
                request.setAttribute("technicianName", technicianName);
        }


        // Set message attributes for view
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);
                
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