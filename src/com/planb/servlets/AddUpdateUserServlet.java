package com.planb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUpdateUser")

public class AddUpdateUserServlet extends HttpServlet {

    @Resource(name = "jdbc/FBP", type = javax.sql.DataSource.class)
    private DataSource dataSource;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><title>JDBC Servlet</title></head><body>");
            out.println("<h1>JDBC Servlet Connected Successfully</h1>");
            out.println("<p>This servlet connects to the database using JNDI DataSource.</p>");
            out.println("</body></html>");

            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/FBP");

            // JDBC variables
            Connection conn = null;
            Statement stmt = null;
            try {
                // Get a connection
                conn = dataSource.getConnection();
                // Create SQL statement
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String displayName = req.getParameter("displayName");
                String emailAddress = req.getParameter("emailAddress");
                req.getAttribute("validatedHashedPassword");
                String hashedPassword = (String) req.getAttribute("validatedHashedPassword");

                String sql = "INSERT INTO User " +
                        "(displayName, firstName, lastName, emailAddress, hashedPassword, lastLogin, accountCreated, isAdmin, paidUser, lastPaymentDate) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, displayName);
                pstmt.setString(2, firstName);
                pstmt.setString(3, lastName);
                pstmt.setString(4, emailAddress);
                pstmt.setString(5, hashedPassword);

                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

                pstmt.setDate(6, date); // account created
                pstmt.setNull(7, java.sql.Types.NULL); // last login
                pstmt.setInt(8, 0); // isAdmin -- 1 for true, 0 for false
                pstmt.setInt(9, 0); // paidUser -- 1 for true, 0 for false
                pstmt.setNull(10, java.sql.Types.NULL); // lastPaymentDate

                // Execute SQL query
                int result = pstmt.executeUpdate();
                // req.setAttribute("dbUpdateResult", result);
                String forwardURl = "/fbp/signup-complete.jsp";
                req.setAttribute("dbUpdateResult", result);
                if (result == 1) {
                    req.setAttribute("Success", "User registered successfully.");
                    req.getRequestDispatcher(forwardURl).forward(req, resp);
                } else {
                    forwardURl = "/fbp/signup.jsp";
                    req.setAttribute("errorMessage", "Database error occurred while registering user.");
                    req.getRequestDispatcher(forwardURl).forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace(out);
            } finally {
                // Clean up JDBC objects
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(out);
                }
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace(out);
                }
            } // Finally block ends
        } // End of try-with-resources for PrintWriter
        catch (NamingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    } // End of doGet method

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
} // End of AddUpdateUserServlet class