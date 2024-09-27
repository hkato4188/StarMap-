package dev.hiro.kato.starmap.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    private JpaDetailsService jpaDetailsService;

    SecurityConfig(JpaDetailsService jpaDetailsService){this.jpaDetailsService = jpaDetailsService;}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/css/**","/images/**").permitAll();
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/register").permitAll();q
                    auth.anyRequest().authenticated();})
                .userDetailsService(jpaDetailsService)
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/users")
                        .failureUrl("/error")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Specify the logout URL (default is /logout)
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true) // Invalidate the session
                        .deleteCookies("JSESSIONID") // Delete cookies
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Redirect to the same custom login page
                        .defaultSuccessUrl("/users")
                        .failureUrl("/error"))
                .build();
    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}












//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }