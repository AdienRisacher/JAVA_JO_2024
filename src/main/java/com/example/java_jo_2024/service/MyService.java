package com.example.java_jo_2024.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Value("${api.key}")
    private String apiKey;

    @Value("${server.port}")
    private String serverPort;

    // ...
}
