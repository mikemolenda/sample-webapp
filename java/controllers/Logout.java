/* 
 * Logout
 *
 * Controls user logout. Clears login session attributes, then redirects home.
 */

package controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        synchronized(session) {
            // Clear all session attributes
            session.invalidate();
        } // end synchronized

        request.setAttribute("messageStyle", "success");
        request.setAttribute("message", "Logout Successful");

        // Redirect Home
        request.getRequestDispatcher("/Home").forward(request, response);
    }
}
