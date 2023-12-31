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
@WebServlet("/resultatConcours")
public class GagnantController extends HttpServlet {

    Bdd bdd = new Bdd();
    Boolean rep;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String connsport = request.getParameter("connsport");
        String prediction = request.getParameter("prediction");
        String defi = request.getParameter("defi");
        String win;
        if(prediction == "France"){
            win = "True";
        }
        else{
            win = "False";
        }
        try {
            rep = bdd.updateConcours(userID, win);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (rep) {
            request.setAttribute("won", rep);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultatConcours.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("won", rep);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultatConcours.jsp");
            dispatcher.forward(request, response);
        }
    }
}