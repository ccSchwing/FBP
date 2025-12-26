package com.planb.servlets;

import java.io.IOException;

import com.planb.utils.FBPUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FBPValidateRegData")
public class FBPValidateRegData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String dispatcherURL = null;
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        if (password != null && password2 != null && password.equals(password2)) {
            try {
                String hashedPassword = FBPUtils.getHashedPassword(password);
                req.setAttribute("validatedHashedPassword", hashedPassword);
                System.out.println("Hashed Password: " + hashedPassword);
                dispatcherURL = "/addUpdateUser";
                // RequestDispatcher jdbcDispatcher = req.getRequestDispatcher(dispatcherURL);
                RequestDispatcher jdbcDispatcher = getServletContext().getRequestDispatcher(dispatcherURL);
                jdbcDispatcher.forward(req, resp);
                // jdbc servlet will add/update user in DB DB
                // Check result of DB operation
                // If success, forward to signup-complete.jsp
                int dbResult = (int) req.getAttribute("dbUpdateResult");
                if (dbResult == 1) {
                    dispatcherURL = "/fbp/signup-complete.jsp";
                } else {
                    req.setAttribute("errorMessage", "Database error occurred while registering user.");
                    dispatcherURL = "/fbp/signup.jsp";
                }
                // Get Request Dispatcher
                // dispatcherURL = "/fbp/signup-complete.jsp";
                RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherURL);
                // Forward the request to appropriate JSP -- Either signup-complete or signup
                // with error
                dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("errorMessage", "Passwords do not match or are null.");
            dispatcherURL = "/fbp/signup.jsp";
            // Get Request Dispatcher
            RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherURL);
            // Forward the request to JSP
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
