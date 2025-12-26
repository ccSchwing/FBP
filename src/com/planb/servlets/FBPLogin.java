package com.planb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.planb.utils.FBPUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FBPLogin")
public class FBPLogin extends HttpServlet {
    @Resource(name = "jdbc/FBP", type = javax.sql.DataSource.class)
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String dispatcherURL = null;
        String loginId = req.getParameter("loginId");
        String password = req.getParameter("password");
        if (password != null && !password.isEmpty() && loginId != null && !loginId.isEmpty()) {
            try {
                String hashedPassword = FBPUtils.getHashedPassword(password);
                req.setAttribute("validatedHashedPassword", hashedPassword);
                dispatcherURL = "/addUpdateUser";
                String sqlString = "SELECT displayName, hashedPassword FROM User WHERE displayName = ? AND hashedPassword = ?";
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/FBP");
                Connection conn = null;
                conn = dataSource.getConnection();
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(sqlString);
                pstmt.setString(1, loginId);
                pstmt.setString(2, hashedPassword);
                var rs = pstmt.executeQuery();
                if (rs.next()) {
                    String dbDisplayName = rs.getString("displayName");
                    String dbHashedPassword = rs.getString("hashedPassword");
                    if (dbDisplayName.equals(loginId) && dbHashedPassword.equals(hashedPassword)) {
                        // Login successful
                        dispatcherURL = "/fbp/login-success.jsp";
                        req.setAttribute("Success", "Login successful! Welcome, " + loginId + ".");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatcherURL);
                        dispatcher.forward(req, resp);
                    } else {
                        // Login failed
                        dispatcherURL = "/fbp/login.jsp";
                        req.setAttribute("errorMessage", "Invalid login ID or password.");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatcherURL);
                        dispatcher.forward(req, resp);
                    }
                } else {
                    // Login failed
                    dispatcherURL = "/fbp/login.jsp";
                    req.setAttribute("errorMessage", "Invalid login ID or password.");

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatcherURL);
                    dispatcher.forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("errorMessage", "Login ID and Password must not be empty.");
            dispatcherURL = "/fbp/login.jsp";
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
