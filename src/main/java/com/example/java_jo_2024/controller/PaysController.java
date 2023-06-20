package com.example.java_jo_2024.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class PaysController {
    @Value("${api.key}")
    private String apiKey;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/java_jo_2024/pays")
    public ResponseEntity<String> getPays() {
        try {
            String apiUrl = "https://api.api-ninjas.com/v1/country?name=United States";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);

            String fact = root.path("fact").asText();

            return ResponseEntity.ok(fact);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
