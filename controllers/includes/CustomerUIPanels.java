/* 
 * CustomerUIPanels
 * 
 * Generates UI panels for customer home page.
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

public class CustomerUIPanels extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(makePanel(
            "TV Plan", 
            "tv-plan.jpg", 
            "TV Plans, from 50 to 200 channels"));

        out.println(makePanel(
            "Internet Plan", 
            "internet-plan.jpg", 
            "High speed Internet access up to 50 Mbps"));

        out.println(makePanel(
            "PPV Live Event", 
            "ppv-live-event.jpg", 
            "Exclusive live sporting events available for order"));

        out.println(makePanel(
            "PPV Movie", 
            "ppv-movie.jpg", 
            "Dozens of movies available on demand"));

        // Don't close output stream - control gets transferred back to the JSP

    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    public String makePanel(String title, String imgSrc, String body) {
        return (
              "<div class=\"col-sm-3\">\n"
            + "<div class=\"panel panel-primary\">\n"
            + "<div class=\"panel-heading\">"+ title +"s</div>\n"
            + "<div class=\"panel-body\">\n"
            + "<img src=\"img/" + imgSrc + "\" class=\"img-responsive\" " 
                + "style=\"width:100%\" alt=\"" + title + "\">\n"
            + "</div>\n"
            + "<div class=\"panel-footer\">\n"
            + "<p>" + body + "</p>\n"
            + "<form action=\"ItemList\">\n"
            + "<input type=\"hidden\" name=\"category\" value=\"" 
                + title + "\">\n"
            + "<input type=\"submit\" class=\"btn btn-success btn-block\" " 
                + "value=\"View Items\">\n"
            + "</form>\n"
            + "</div>\n"
            + "</div>\n"
            + "</div>");
    }
}