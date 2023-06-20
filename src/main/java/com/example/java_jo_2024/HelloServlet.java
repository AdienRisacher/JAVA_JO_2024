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
        Context ctx = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/jo");

            con = ds.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM CLIENTS");

            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print("<html><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>IDCLIENT</th>");
            out.print("<th>MAILCLIENT</th>");
            out.print("<th>NOMCLIENT</th>");
            out.print("<th>MDPCLIENT</th>");

            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getInt("IDCLIENT") + "</td>");
                out.print("<td>" + rs.getString("MAILCLIENT") + "</td>");
                out.print("<td>" + rs.getString("NOMCLIENT") + "</td>");
                out.print("<td>" + rs.getString("MDPCLIENT") + "</td>");
                out.print("</tr>");
            }
            out.print("</table></body><br/>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

        public void destroy() {
    }
}