package dev.hkato.nasa.Nasa.API.CRUD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserService userService, BCryptPasswordEncoder encoder){
		return args -> {

			userService.save(new User("user", encoder.encode("password")));
		};
	}
}
