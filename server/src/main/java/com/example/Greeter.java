package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a Greeter servlet.
 */
@WebServlet("/action_page.php")
public class GreeterServlet extends HttpServlet {

    /**
     * This is a constructor.
     */
    public GreeterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("Name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");

        // Create a greeting message
        Greeter greeter = new Greeter();
        String greeting = greeter.greet(name);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + greeting + "</h1>");
        out.println("<p>Mobile: " + mobile + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Password: " + password + "</p>"); // Be careful with displaying passwords!
        out.println("</body></html>");
    }
}
