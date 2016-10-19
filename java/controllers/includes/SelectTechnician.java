/* 
 * SelectTechnician
 *
 * Displays a dropdown from which to select technicians, or a hidden field
 * containing a technician ID if requested with a technicianID attribute.
 */

package controllers.includes;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class SelectTechnician extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String technicianId = (String) request.getAttribute("technicianId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (technicianId != null) {
            // Include hidden field with technician ID baked in
            out.println("<input type=\"hidden\" name=\"technicianId\" "
                + "value=\"" + technicianId + "\">");
        } else {
            // Include dropdown field listing all technicians
            out.println("<label for=\"technicianId\">Technician: </label>");
            out.println("<select name=\"technicianId\" class=\"form-control\">");

            for (Entry<String, User> entry : EntityData.getUsers().entrySet()) {
                User user = entry.getValue();

                if (user.getRole().equals("Technician")) {
                    // Add username and full name to select list
                    String value = user.getUsername();
                    String display = user.getLName() + ", " + user.getFName();

                    out.println("<option value=\"" + value + "\">"
                        + display + " (" + value + ")</option>");
                }
            }

            out.println("</select>");
        }
        // Don't close output stream, control transfers back to JSP
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
