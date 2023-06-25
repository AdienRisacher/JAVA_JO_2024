package com.example.java_jo_2024.controller;

import com.example.java_jo_2024.model.entity.Pays;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
public class PaysController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/java_jo_2024/pays")
    public @ResponseBody ResponseEntity<Pays> getPays() {
        try {
            String apiUrl = "https://api.api-ninjas.com/v1/country?name=United States";

            HttpHeaders headers = new HttpHeaders();
            headers.add("accept", "application/json");
            headers.add("Authorization", "X-Api-Key " + apiKey);

            RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, new URI(apiUrl));

            ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String response = responseEntity.getBody();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response);

                String iso2 = root.path("iso2").asText();
                String name = root.path("name").asText();
                String capital = root.path("capital").asText();
                String population = root.path("population").asText();


                Pays pays = new Pays(iso2, name, capital, "", population, "");

                return ResponseEntity.ok(pays);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
