/* 
 * ItemOrderTable
 * 
 * Generates a table of items for the customer to order.
 * 
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2017
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

public class ItemOrderTable extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        Item item;
        Map<String, Item> items = EntityData.getItems();
        String category = request.getParameter("category");     
        boolean dateFlag = (category.equals("PPV Live Event"));

        response.setContentType("text/html"); // neccessary?
        PrintWriter out = response.getWriter();

        out.println(
              "<table class=\"table table-hover text-left\">"
            + "<thead>\n" 
            + "<th>Item</th>\n"
            + "<th>" + (dateFlag ? "Event Date" : "&nbsp;") + "</th>\n"
            + "<th>Price</th>\n" 
            + "<th>&nbsp;</th>\n" 
            + "</thead>\n" 
            + "<tbody>");
        
        for (Entry<String, Item> entry : items.entrySet()) {
            item = entry.getValue();
            if (item.getCategory().equals(category)) {
                String name = item.getName();
                String date = 
                    (dateFlag ? ((PPVLiveEvent)item).dateString() : "&nbsp;");
                String price = item.getPrice().toString();
                String id = item.getItemId();

                out.println(
                      "<tr>\n" 
                    + "<td>" + name + "</td>\n"
                    + "<td>" + date + "</td>\n"
                    + "<td>$" + price + "</td>\n"
                    + "<td>\n" 
                    + "<form action=\"ViewInvoice\">\n"
                    + "<input type=\"hidden\" name=\"itemId\" value=\"" + id
                        + "\">\n"
                    + "<input type=\"submit\" class="
                        + "\"btn btn-success btn-sm\" value=\"Order\">\n"
                    + "</form>\n" 
                    + "</td>\n" 
                    + "</tr>");
            }
        }

        out.println("</tbody>\n</table>");
        
        // Don't close output stream - control gets transferred back to the JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}