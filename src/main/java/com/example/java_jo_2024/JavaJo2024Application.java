package com.example.java_jo_2024;


import com.example.java_jo_2024.controller.PaysController;
import com.example.java_jo_2024.model.entity.Pays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class JavaJo2024Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(JavaJo2024Application.class, args);

		PaysController paysController = context.getBean(PaysController.class);
		ResponseEntity<Pays> response = paysController.getPays();

		if (response.getStatusCode().is2xxSuccessful()) {
			String fact = response.getBody();
			System.out.println("Fact: " + fact);
		} else {
			System.out.println("Failed to retrieve the fact.");
		}

		context.close();
	}

}
