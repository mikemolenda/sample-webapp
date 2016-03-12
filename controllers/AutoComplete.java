/* 
 * AutoComplete
 * 
 * Responds with entity data for search autocompletion.
 *
 * "complete" & "lookup" actions borrowed from CIS419 source code (ajax-my-app)
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
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.items.*;

public class AutoComplete extends HttpServlet {

    private Map<String, Item> items = EntityData.getItems();

    /**
     * Handles HTTP GET requests
     * @param   request     servlet request
     * @param   response    servlet response
     */
    @Override
    public void doGet(
            HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String action = request.getParameter("action");  // action to perform
        String targetId = request.getParameter("id");  // value of completeField

        StringBuffer sb = new StringBuffer();

        //TODO If action or targetId null, redirect to error

        // Format completeField value for ease of matching
        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        }

        boolean itemsAdded = false;  // flag whether an item was added to table

        // complete action populates completeTable data
        if (action.equals("complete")) {

            if (!targetId.equals("")) {
                // If completeField is not empty, check against inventory
                for (Entry<String, Item> entry : items.entrySet()) {
                    Item item = entry.getValue();
                    String name = item.getName();

                    // Check against: name
                    if (name.toLowerCase().startsWith(targetId)) {
                        // If match found, add data to XML response
                        sb.append("<item>");
                        sb.append("<id>" + entry.getKey() + "</id>");
                        sb.append("<name>" + name + "</name>");
                        sb.append("</item>");
                        itemsAdded = true;
                    }
                }
            } 

            // If items were added, respond with XML, otherwise SC 204
            if (itemsAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                PrintWriter out = response.getWriter();
                out.write("<items>" + sb.toString() + "</items>");
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } // end action complete

        // lookup action forwards request to appropriate item page
        if (action.equals("lookup")) {

            if (targetId != null) {
                
                String key = targetId.trim();
                String url = "ViewInvoice?itemId=" + key;

                if (items.containsKey(key)) { 
                    request.getRequestDispatcher(url).forward(request, response);
                }
            }
        } // end action lookup

    } // end doGet
}