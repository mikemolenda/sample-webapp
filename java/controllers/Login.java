/* 
 * Login
 *
 * Controls user login. Assigns a role to the session user based on login type,
 * then redirects Home.
 */

package controllers;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
import model.roles.*;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<String, User> users = EntityData.getUsers();

        if (users.get(username) != null) {
            // Username valid
            User user = users.get(username);

            synchronized(session) {

                if (user.getPassword().equals(password.trim())) {
                    // Password valid
                    if (user.getRole() != null) {
                        // Set session user
                        session.setAttribute("user", user);
                        session.setAttribute("username", user.getUsername());
                        session.setAttribute("fullname",
                            (user.getFName() + " " + user.getLName()));
                        session.setAttribute("role", user.getRole());
                    }
                } else {
                    // Password invalid
                    request.setAttribute("messageStyle", "danger");
                    request.setAttribute("message", "Invalid password");
                }

            } // end synchronized
        } else {
            // Username invalid
            request.setAttribute("messageStyle", "danger");
            request.setAttribute("message", "Invalid username");
        }

        // Redirect Home
        request.getRequestDispatcher("/Home").forward(request, response);
    }
}
