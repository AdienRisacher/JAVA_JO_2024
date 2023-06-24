package com.example.java_jo_2024;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/callback")
public class ReponseGoogle extends HttpServlet {

    private static final String CLIENT_ID = "1074610225302-8viasu7c6h6eh8c4tc18f5h4fa9ad5ll.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "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";
    private static final String REDIRECT_URI = "http://localhost:8080/JAVA_JO_2024_war_exploded/callback";
    private static final String TOKEN_URL = "https://oauth2.googleapis.com/token";
    private static final String USERINFO_URL = "https://www.googleapis.com/oauth2/v3/userinfo";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");

        String tokenPayload = "code=" + URLEncoder.encode(code, "UTF-8") + "&client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET + "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8") +
                "&grant_type=authorization_code";

        // Request access token
        URL tokenURL = new URL(TOKEN_URL);
        HttpURLConnection tokenConnection = (HttpURLConnection) tokenURL.openConnection();
        tokenConnection.setRequestMethod("POST");
        tokenConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        tokenConnection.setDoOutput(true);
        tokenConnection.getOutputStream().write(tokenPayload.getBytes(StandardCharsets.UTF_8));

        InputStream tokenResponse = tokenConnection.getInputStream();
        Scanner tokenScanner = new Scanner(tokenResponse, StandardCharsets.UTF_8.name());
        String tokenResponseBody = tokenScanner.useDelimiter("\\A").next();
        tokenScanner.close();

        JsonObject tokenJson = JsonParser.parseString(tokenResponseBody).getAsJsonObject();
        String accessToken = tokenJson.get("access_token").getAsString();

        // Request user info
        URL userInfoURL = new URL(USERINFO_URL);
        HttpURLConnection userInfoConnection = (HttpURLConnection) userInfoURL.openConnection();
        userInfoConnection.setRequestProperty("Authorization", "Bearer " + accessToken);

        InputStream userInfoResponse = userInfoConnection.getInputStream();
        Scanner userInfoScanner = new Scanner(userInfoResponse, StandardCharsets.UTF_8.name());
        String userInfoResponseBody = userInfoScanner.useDelimiter("\\A").next();
        userInfoScanner.close();

        JsonObject userInfoJson = JsonParser.parseString(userInfoResponseBody).getAsJsonObject();
        String email = userInfoJson.get("email").getAsString();

        // Do something with the user information
        // For example, store the email in a session and redirect to a protected resource
        request.getSession().setAttribute("email", email);
        request.getRequestDispatcher("callback.jsp").forward(request, response);

    }
}
