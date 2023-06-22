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
@WebServlet("/resultatInscription")
public class InscriptionController extends HttpServlet {

    Bdd bdd = new Bdd();
    User user;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        try {
            user = bdd.createUser(nom, email, mdp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultatInscription.jsp");
        dispatcher.forward(request, response);
    }


}