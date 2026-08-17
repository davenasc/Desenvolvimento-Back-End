package br.edu.ifsp.bra.intro_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class IntroSpringApplication {
	@Autowired
	User user;

	@GetMapping("/user")
	public User getUser() {
		return user;
	}

	@GetMapping("/hello")
	public String helloWorld() {
		return "hello world!";
	}

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
	}

}
