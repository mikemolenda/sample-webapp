/* 
 * OrderTable
 *
 * Displays a table of active orders.
 * Manager can update or cancel any one.
 * Account Specialist view only.
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

public class OrderTable extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, Order> orders = EntityData.getOrders();
        String role = null;
        String message = (String) request.getAttribute("message");
        String messageStyle = (String) request.getAttribute("messageStyle");

        // Get role
        synchronized (session) {
            if (session.getAttribute("role") != null) {
                role = (String) session.getAttribute("role");
            }
        }

        // Enable buttons for certain user types
        String flagModify = "disabled";
        String flagRemove = "disabled";

        // Manager can modify/delete orders
        if (role.equals("Manager")) {
            flagModify = "active";
            flagRemove = "active";
        }


        // Print table header
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<thead>");
        out.println("<th>Order ID</th>");
        out.println("<th>Item</th>");
        out.println("<th>Customer</th>");
        out.println("<th>Order Date</th>");
        out.println("<th>Action</th>");
        out.println("</thead>");
        out.println("<tbody>");

        if (role.equals("Manager") || role.equals("Account Specialist")) {

            for (Entry<String, Order> entry : orders.entrySet()) {

                Order order = entry.getValue();

                String orderId = order.getOrderId();
                String itemName = order.getItem().getName();
                String customer = order.getCustomer().getLName() + ", "
                                + order.getCustomer().getFName();
                String orderDate = order.dateString();

                out.println("<tr>");
                out.println("<td>" + orderId + "</td>");
                out.println("<td>" + itemName + "</td>");
                out.println("<td>" + customer + "</td>");
                out.println("<td>" + orderDate + "</td>");
                out.println("<td>");
                out.println("<a href=\"ModifyOrder?orderId=" + orderId + "\" "
                    + "class=\"btn btn-info btn-sm " + flagModify + "\">"
                    + "Modify</a>");
                out.println("&nbsp;");
                out.println("<a href=\"ViewOrders?removeOrder=" + orderId
                    + "\" class=\"btn btn-danger btn-sm " + flagRemove + "\">"
                    + "Remove</a>");
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
