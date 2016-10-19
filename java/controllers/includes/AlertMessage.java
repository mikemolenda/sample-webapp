/* 
 * AlertMessage
 * 
 * Displays the status message returned by add/remove order actions.
 * 


 
 *
 
 *
 
 
 */

package controllers.includes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AlertMessage extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String message = (String) request.getAttribute("message");
        String messageStyle = (String) request.getAttribute("messageStyle");

        if (message != null) {
            
            String url = "includes/alert.jsp";
            
            // Set messageStyle according to parameter
            if (messageStyle != null) {
                messageStyle = "alert alert-" + messageStyle; 
            } else {
                messageStyle = "alert alert-info";
            }

            request.setAttribute("messageStyle", messageStyle);

            request.getRequestDispatcher(url).include(request, response);
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