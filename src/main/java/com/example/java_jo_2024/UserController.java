package com.example.java_jo_2024;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/listuser")
public class UserController extends HttpServlet {

    Bdd bddConnexion = new Bdd();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialisez la liste des concours
        ArrayList<User> listUser = null;
        try {
            listUser = bddConnexion.listAllUser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("listeUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listuser.jsp");
        dispatcher.forward(request, response);
        }
        // Redirigez vers la page JSP



}