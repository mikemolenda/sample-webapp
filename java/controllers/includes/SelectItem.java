/* 
 * SelectItem
 * 
 * Displays a dropdown from which to select items, limited by user.
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

package controllers.includes;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.items.*;
import model.roles.*;
import model.system.*;

public class SelectItem extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, Item> items;
        String role = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get user role
        synchronized(session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        } // end synchronized

        // Enable option groups based on condition. Empty string enables.
        String flagPPVM = " disabled";
        String flagPPVE = " disabled";
        String flagInet = " disabled";
        String flagTV = " disabled";

        // Manager can choose any item
        if (role.equals("Manager")) {
            flagPPVM = "";
            flagPPVE = "";
            flagInet = "";
            flagTV = "";
        }

        // Account specialist can only choose PPV items
        if (role.equals("Account Specialist")) {
            flagPPVM = "";
            flagPPVE = "";
        }

        out.println("<label for=\"itemId\">Select Item: </label>");
        out.println("<select name=\"itemId\" class=\"form-control\">");

        out.println("<optgroup label=\"PPV Movies\"" + flagPPVM + ">");
        for (Entry<String, Item> entry : 
                EntityData.getItemsByCategory("PPV Movie").entrySet()) {

            Item item = entry.getValue();
            
            out.println("<option value=\"" + item.getItemId() + "\">"
                + item.getName() + " $" + item.getPrice() + "</option>");
        }

        out.println("<optgroup label=\"PPV Live Events\"" + flagPPVE + ">");
        for (Entry<String, Item> entry : 
                EntityData.getItemsByCategory("PPV Live Event").entrySet()) {

            Item item = entry.getValue();
            
            out.println("<option value=\"" + item.getItemId() + "\">"
                + item.getName() + " (" + ((PPVLiveEvent)item).dateString() 
                + ") $" + item.getPrice() + "</option>");
        }

        out.println("<optgroup label=\"TV Plans\"" + flagTV + ">");
        for (Entry<String, Item> entry : 
                EntityData.getItemsByCategory("TV Plan").entrySet()) {

            Item item = entry.getValue();
            
            out.println("<option value=\"" + item.getItemId() + "\">"
                + item.getName() + " $" + item.getPrice() + "</option>");
        }

        out.println("<optgroup label=\"Internet Plans\"" + flagInet + ">");
        for (Entry<String, Item> entry : 
                EntityData.getItemsByCategory("Internet Plan").entrySet()) {

            Item item = entry.getValue();
            
            out.println("<option value=\"" + item.getItemId() + "\">"
                + item.getName() + " $" + item.getPrice() + "</option>");
        }

        out.println("</select>");

        // Don't close output stream, control transfers back to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}