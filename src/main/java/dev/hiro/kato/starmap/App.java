package dev.hiro.kato.starmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

}



//	@Bean
//	CommandLineRunner commandLineRunner(UserService userService, BCryptPasswordEncoder encoder){
//		return args -> {
//
//			userService.save(new User("user", encoder.encode("password")));
//		};
//	}