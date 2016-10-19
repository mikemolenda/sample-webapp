/* 
 * ItemOrderTable
 *
 * Generates a table of items for the customer to order.
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

        Map<String, Item> items = EntityData.getItems();
        String url;

        String category = request.getParameter("category");
        boolean dateFlag = (category.equals("PPV Live Event"));

        // Set table column header text
        request.setAttribute("th1", "Item");
        request.setAttribute("th2", (dateFlag ? "Event Date" : "&nbsp;"));
        request.setAttribute("th3", "Price");
        request.setAttribute("th4", "&nbsp;");

        url = "/includes/table-head-4.jsp";
        request.getRequestDispatcher(url).include(request, response);

        // Generate new tr for every item that matches category
        for (Entry<String, Item> entry : items.entrySet()) {

            Item item = entry.getValue();

            if (item.getCategory().equals(category)) {
                String date =
                    (dateFlag ? ((PPVLiveEvent)item).dateString() : "&nbsp;");

                // Set table column parameters
                request.setAttribute("td1", item.getName());
                request.setAttribute("td2", date);
                request.setAttribute("td3", item.getPrice().toString());
                request.setAttribute("action", "ViewInvoice");
                request.setAttribute("paramType", "itemId");
                request.setAttribute("param", item.getItemId());
                request.setAttribute("btntext", "Order");

                url = "/includes/table-tr-form-4.jsp";
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
