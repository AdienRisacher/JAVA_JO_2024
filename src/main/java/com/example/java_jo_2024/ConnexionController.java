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
@WebServlet("/resultatConnexion")
public class ConnexionController extends HttpServlet {

    Bdd bdd = new Bdd();
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        try {
            user = bdd.connexionUser(email, mdp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            if (user != null) {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("resultatConnexion.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", "E-mail ou MDP incorrect");
                RequestDispatcher dispatcher = request.getRequestDispatcher("resultatConnexion.jsp");
                dispatcher.forward(request, response);
            }
        }
    }