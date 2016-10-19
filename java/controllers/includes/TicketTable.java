/* 
 * TicketTable
 * 
 * Displays a table of support tickets.
 * If passed with status parameter, shows only open or completed tickets.
 * If technician attribute passed, shows tickets for that technician only, 
 * otherwise shows tickets for all technicians (admin)
 * 


 
 *
 
 *
 
 
 */

package controllers.includes;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.items.*;
import model.roles.*;
import model.system.*;

public class TicketTable extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, Ticket> tickets;
        String status = request.getParameter("status");
        String role = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get ticket data based on whether a tecnician attribute was passed
        if (request.getAttribute("technician") != null) {
            // Get tickets for current technician only
            Technician technician = (Technician) request.getAttribute("technician");
            tickets = EntityData.getTickets(technician);
        } else {
            // Get tickets for all technicians
            tickets = EntityData.getTickets();
        }

        // Get role
        synchronized (session) {
            role = (String) session.getAttribute("role");
        }

        // Generate table header
        out.println("<thead>");
        out.println("<th>Ticket ID</th>");
        out.println("<th>Technician</th>");
        out.println("<th>Customer</th>");
        out.println("<th>Schedule Date</th>");
        out.println("<th>Details</th>");
        out.println("<th>Status</th>");
        out.println("</thead>");
        out.println("<tbody>");

        // Display open or closed orders, depending on parameter
        if (status != null) {
            if (status.equals("open")) {

                // Display only open orders
                for (Entry<String, Ticket> entry : tickets.entrySet()) {
                    Ticket t = entry.getValue();
                    Technician tech = t.getTechnician();
                    Customer c = t.getCustomer();
                    String techName = tech.getLName() + ", " + tech.getFName();
                    String customerName = c.getLName() + ", " + c.getFName();

                    if (t.isOpen()) {
                        out.println("<tr>");
                        out.println("<td>" + t.getTicketId() + "</td>");
                        out.println("<td>" + techName + "</td>");
                        out.println("<td>" + customerName + "</td>");
                        out.println("<td>" + t.dateString() + "</td>");
                        out.println("<td>" + t.getMessage() + "</td>");
                        if (role.equals("Account Specialist")) {
                            out.println("<td><strong>Open</strong></td>");
                        } else {
                            out.println("<td>");
                            out.println("<a href=\"ViewTickets?completeTicket="
                                + t.getTicketId() 
                                + "\" class=\"btn btn-success btn-sm\">Complete</a>");
                            out.println("&nbsp;");
                            out.println("<a href=\"ViewTickets?cancelTicket="
                                + t.getTicketId() 
                                + "\" class=\"btn btn-danger btn-sm\">Cancel</a>");
                            out.println("</td>");
                        } 
                        out.println("</tr>");
                    }
                }

                out.println("</tbody>");
            } 

            if (status.equals("closed")) {
                // Display only closed orders
                for (Entry<String, Ticket> entry : tickets.entrySet()) {
                    Ticket t = entry.getValue();
                    Technician tech = t.getTechnician();
                    Customer c = t.getCustomer();
                    String techName = tech.getLName() + ", " + tech.getFName();
                    String customerName = c.getLName() + ", " + c.getFName();

                    if (!t.isOpen()) {
                        out.println("<tr>");
                        out.println("<td>" + t.getTicketId() + "</td>");
                        out.println("<td>" + techName + "</td>");
                        out.println("<td>" + customerName + "</td>");
                        out.println("<td>" + t.dateString() + "</td>");
                        out.println("<td>" + t.getMessage() + "</td>");
                        out.println("<td>Completed</td>");
                        out.println("</tr>");
                    }
                }

                out.println("</tbody>");
            }              
        } else {
            // Display orders of all status types
            for (Entry<String, Ticket> entry : tickets.entrySet()) {
                Ticket t = entry.getValue();
                Technician tech = t.getTechnician();
                Customer c = t.getCustomer();
                String techName = tech.getLName() + ", " + tech.getFName();
                String customerName = c.getLName() + ", " + c.getFName();

                out.println("<tr>");
                out.println("<td>" + t.getTicketId() + "</td>");
                out.println("<td>" + techName + "</td>");
                out.println("<td>" + customerName + "</td>");
                out.println("<td>" + t.dateString() + "</td>");
                out.println("<td>" + t.getMessage() + "</td>");

                // change last td based on completion status    
                if (t.isOpen()) {
                    if (role.equals("Account Specialist")) {
                        out.println("<td><strong>Open</strong></td>");
                    } else {
                        out.println("<td>");
                        out.println("<a href=\"ViewTickets?completeTicket="
                            + t.getTicketId() 
                            + "\" class=\"btn btn-success btn-sm\">Complete</a>");
                        out.println("&nbsp;");
                        out.println("<a href=\"ViewTickets?cancelTicket="
                            + t.getTicketId() 
                            + "\" class=\"btn btn-danger btn-sm\">Cancel</a>");
                        out.println("</td>");
                    }
                } else { 
                    out.println("<td>Completed</td>");
                }
                
                out.println("</tr>");
            }

            out.println("</tbody>");
        }
        // Don't close output stream, control returns to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}