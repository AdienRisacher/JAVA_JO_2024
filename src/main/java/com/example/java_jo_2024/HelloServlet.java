package com.example.java_jo_2024;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");


        Context initContext = null;
        try {
            initContext = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        Context envContext = null;
        try {
            envContext = (Context) initContext.lookup("java:/comp/env");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        DataSource dataSource = null;
        try {
            dataSource = (DataSource) envContext.lookup("jdbc/JO");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
// Use the connection for database operations

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            rs = stmt.executeQuery("select * from CLIENTS");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while(true)
        {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            out.print("<tr>");
            try {
                out.print("<td>" + rs.getInt("IDCLIENT") + "</td>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                out.print("<td>" + rs.getString("MAILCLIENT") + "</td>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                out.print("<td>" + rs.getString("NOMCLIENT") + "</td>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                out.print("<td>" + rs.getString("MDPCLIENT") + "</td>");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            out.print("</tr>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}