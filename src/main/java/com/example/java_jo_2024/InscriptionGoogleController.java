package com.example.java_jo_2024;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class InscriptionGoogleController extends HttpServlet {

    private static final String CLIENT_ID = "1074610225302-8viasu7c6h6eh8c4tc18f5h4fa9ad5ll.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "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";
    private static final String REDIRECT_URI = "http://localhost:8080/JAVA_JO_2024_war_exploded/callback";
    private static final String AUTH_URL = "https://accounts.google.com/o/oauth2/auth";
    private static final String TOKEN_URL = "https://accounts.google.com/o/oauth2/token";
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirectURL = AUTH_URL + "?client_id=" + CLIENT_ID + "&redirect_uri=" +
                URLEncoder.encode(REDIRECT_URI, "UTF-8") + "&response_type=code&scope=" +
                URLEncoder.encode(SCOPE, "UTF-8");

        request.setAttribute("loginURL", redirectURL);
        RequestDispatcher dispatcher = request.getRequestDispatcher("inscription.jsp");
        dispatcher.forward(request, response);
    }
}

