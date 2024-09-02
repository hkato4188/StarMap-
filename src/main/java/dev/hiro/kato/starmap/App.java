package dev.hiro.kato.starmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(UserService userService, BCryptPasswordEncoder encoder){
//		return args -> {
//
//			userService.save(new User("user", encoder.encode("password")));
//		};
//	}
}
