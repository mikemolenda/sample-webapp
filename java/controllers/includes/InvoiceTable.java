/* 
 * InvoiceTable
 * 
 * Displays a table with all of a customer's current orders.
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

public class InvoiceTable extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        Map<String, Order> orders = EntityData.getOrders();
        Customer customer = (Customer) request.getAttribute("customer");
        String url;

        // Set table column header text
        request.setAttribute("th1", "Order ID");
        request.setAttribute("th2", "Item");        
        request.setAttribute("th3", "Order Date");
        request.setAttribute("th4", "Price");  
        request.setAttribute("th5", "&nbsp;");

        // Generate table header
        url = "/includes/table-head-5.jsp";
        request.getRequestDispatcher(url).include(request, response);

        // Generate tr for every order that matches customer
        for (Entry<String, Order> entry : orders.entrySet()) {

            Order order = entry.getValue();
            Item item = order.getItem();

            if (order.getCustomer().equals(customer)) {
                // Set table column parameters
                request.setAttribute("td1", order.getOrderId());
                request.setAttribute("td2", item.getName());
                request.setAttribute("td3", order.dateString());
                request.setAttribute("td4", item.getPrice().toString());
                request.setAttribute("action", "ViewInvoice");
                request.setAttribute("paramType", "removeOrder");
                request.setAttribute("param", order.getOrderId());
                request.setAttribute("btntext", "Cancel");

                // Generate table row
                url = "/includes/table-tr-form-5.jsp";
                request.getRequestDispatcher(url).include(request, response);
            }
        }
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}