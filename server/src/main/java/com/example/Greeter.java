package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This servlet handles registration for the Anime Legion.
 */
@WebServlet("/action_page.php")
public class AnimeLegionServlet extends HttpServlet {

    /**
     * Default constructor.
     */
    public AnimeLegionServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("Name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");

        // Create a welcome message
        String welcomeMessage = String.format("Welcome, %s! You are now a Warrior of the Anime Legion.", name);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + welcomeMessage + "</h1>");
        out.println("<p>Mobile: " + mobile + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
