/*
 * NewCustomer
 * GET: Displays add customer form
 * POST: Adds customer to HashMap, displays confirmation
 * Only available to admins and managers.
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

public class NewCustomer extends HttpServlet {

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
            url = "/add-customer.jsp";
        }

        request.setAttribute("fullName", "new customer");
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

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String ccNo = request.getParameter("ccNo");

        // If manager or admin, add customer and display customer list
        if (role.equals("Manager") || role.equals("Account Specialist")) {
            url = "ViewCustomers";
            message = EntityData.addCustomer(username, email, password, fName,
                    lName, ccNo);
            messageStyle =
                    message.matches(".*[Ss]uccess.*") ? "success" : "danger";
        }

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);

        request.getRequestDispatcher(url).forward(request, response);
    }
}
