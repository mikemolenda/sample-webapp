/* 
 * CustomerTable
 *
 * Displays a table of active customers.
 * Managers and Admins can update or cancel any one.
 */

package controllers.includes;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class CustomerTable extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, Customer> customers = EntityData.getCustomers();
        String role = null;
        String message = (String) request.getAttribute("message");
        String messageStyle = (String) request.getAttribute("messageStyle");

        // Get role
        synchronized (session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        }

        // Print table header
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<thead>");
        out.println("<th>Username</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Password</th>");
        out.println("<th>Credit Card #</th>");
        out.println("<th>Action</th>");
        out.println("</thead>");
        out.println("<tbody>");

        if (role.equals("Manager") || role.equals("Account Specialist")) {

            for (Entry<String, Customer> entry : customers.entrySet()) {

                Customer customer = entry.getValue();

                String username = customer.getUsername();
                String name = customer.getLName() + ", " + customer.getFName();
                String email = customer.getEmail();
                String password = customer.getPassword();
                String ccNo = customer.getCreditCardNo();

                out.println("<tr>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("<td>" + ccNo + "</td>");
                out.println("<td>");
                out.println("<a href=\"Account?customerId=" + username
                    + "\" class=\"btn btn-info btn-sm\">Update</a>");
                out.println("&nbsp;");
                out.println("<a href=\"ViewCustomers?removeCustomer=" + username
                    + "\" class=\"btn btn-danger btn-sm\">Remove</a>");
                out.println("</tr>");
            }
        }

        out.println("</tbody>");

        // Do not close output stream, control returns to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
