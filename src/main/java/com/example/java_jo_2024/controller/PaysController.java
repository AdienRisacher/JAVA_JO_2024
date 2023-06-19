package com.example.java_jo_2024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/pays")
public class PaysController {

    @GetMapping
    public String getPays() throws Exception {
        URL url = new URL("https://api.api-ninjas.com/v1/country?name=United States");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        String fact = root.path("fact").asText();

        return fact;
    }
}

