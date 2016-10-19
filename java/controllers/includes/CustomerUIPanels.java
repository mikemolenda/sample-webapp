/* 
 * CustomerUIPanels
 *
 * Generates UI panels for customer home page.
 */

package controllers.includes;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.items.*;

public class CustomerUIPanels extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        makePanel(request, response,
            "TV Plan", "TV Plans, from 50 to 200 channels");
        makePanel(request, response,
            "Internet Plan", "High speed Internet access up to 50 Mbps");
        makePanel(request, response,
            "PPV Live Event", "Live sporting events available for order");
        makePanel(request, response,
            "PPV Movie", "Dozens of movies available on demand");
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void makePanel(
            HttpServletRequest request, HttpServletResponse response,
            String title, String body) throws ServletException, IOException {

        String url = "includes/ui-panel.jsp";
        String heading = title + "s";
        String imgSrc =
            "img/" + title.toLowerCase().replace(' ', '-') + ".jpg";

        request.setAttribute("size", "col-sm-3");
        request.setAttribute("heading", heading);
        request.setAttribute("imgSrc", imgSrc);
        request.setAttribute("bodytext", body);
        request.setAttribute("action", "ItemList");
        request.setAttribute("param", title);
        request.setAttribute("btntext", "View Items");

        request.getRequestDispatcher(url).include(request, response);
    }
}
