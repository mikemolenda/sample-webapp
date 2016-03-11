/* 
 * Account
 * 
 * Displays appropriate account management page for user
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

public class Account extends HttpServlet {

    /**
     * Handle GET requests
     * User arrives via link
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String customerId = request.getParameter("customerId");

        String url;
        User user = null;
        String role = "";
        Customer customer = null;

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

        if (customer != null) {
            url = "/account-info.jsp";
            request.setAttribute("customer", customer);

            request.setAttribute("username", customer.getUsername());
            request.setAttribute("password", customer.getPassword());
            request.setAttribute("email", customer.getEmail());
            request.setAttribute("fName", customer.getFName());
            request.setAttribute("lName", customer.getLName());  
            request.setAttribute("fullName", 
                    customer.getFName() + " " + customer.getLName());
            request.setAttribute("ccNo", customer.getCreditCardNo());          

        } else {
            url = "/Home";
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

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String ccNo = request.getParameter("ccNo"); 

        String message;
        String messageStyle;
        String url = "/account-info.jsp";
        String currentUser;

        // Update customer
        message = EntityData.modifyCustomer(username, email, password, fName, 
            lName, ccNo);
        messageStyle = message.matches(".*[Ss]uccess.*") ? "success" : "danger";

        Customer customer = (Customer) EntityData.getUsers().get(username);

        synchronized (session) {
            currentUser = (String) session.getAttribute("username");
        } // end synchronized

        // If current customer, update session
        if (currentUser.equals(username)) {

            synchronized (session) {

                session.setAttribute("user", customer);
                session.setAttribute("username", customer.getUsername());
                session.setAttribute("fullname", 
                    (customer.getFName() + " " + customer.getLName()));
                session.setAttribute("role", customer.getRole());

            } // end synchronized
        }

        // Set message and redirect to appropriate URL
        request.setAttribute("message", message);
        request.setAttribute("messageStyle", messageStyle);
        request.setAttribute("username", customer.getUsername());
        request.setAttribute("password", customer.getPassword());
        request.setAttribute("email", customer.getEmail());
        request.setAttribute("fName", customer.getFName());
        request.setAttribute("lName", customer.getLName());  
        request.setAttribute("fullName", 
                customer.getFName() + " " + customer.getLName());
        request.setAttribute("ccNo", customer.getCreditCardNo()); 

        request.getRequestDispatcher(url).forward(request, response);
    }
}