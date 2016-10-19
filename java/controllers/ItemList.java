/* 
 * TVPlans
 *
 * Controls the TV Plans page displayed to the user.
 */

package controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;
import model.items.*;

public class ItemList extends HttpServlet {

    /**
     * Handle GET requests (e.g. from URL)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String category = request.getParameter("category");

        String role;
        String url;
        String imgSplash;

        synchronized(session) {
            // Get user role
            role = (String) session.getAttribute("role");
        } // end synchronized

        // If user is not a customer, get out of here
        if (role.equals("Customer")) {
            url = "/item-list.jsp";
        } else {
            url = "/Home";
        }

        // Set request parameters based on category
        if (category != null) {
            imgSplash = category.toLowerCase().replace(' ', '-');
        } else {
            imgSplash = "main";
        }

        // Forward to appropriate page for request
        request.setAttribute("imgSplash", imgSplash);
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
