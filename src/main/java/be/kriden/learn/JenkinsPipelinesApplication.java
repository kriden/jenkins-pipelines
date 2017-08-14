package be.kriden.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsPipelinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsPipelinesApplication.class, args);
		// TODO Implement application

		int number = 3;
		int target = 5;

		target =- number;
		target =+ number;
	}
}
