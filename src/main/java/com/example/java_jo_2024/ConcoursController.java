package com.example.java_jo_2024;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/concours")
public class ConcoursController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialisez la liste des concours
        List<Concours> concoursList = (ArrayList<Concours>) request.getAttribute("concoursList");
        if(concoursList == null) {
            concoursList = new ArrayList<>();
            concoursList.add(new Concours("Concours de connaissances sportives", "Testez vos connaissances sportives pour gagner des places !"));
            concoursList.add(new Concours("Concours de prédictions", "Faites des prédictions sur les résultats et gagnez des places !"));
            concoursList.add(new Concours("Défis virtuels liés aux sports olympiques", "Relevez des défis virtuels pour tenter de gagner des places !"));

            // Ajoutez la liste des concours à la requête
           request.setAttribute("concoursList", concoursList);
        }
        // Redirigez vers la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("concours.jsp");
        dispatcher.forward(request, response);
    }



}
