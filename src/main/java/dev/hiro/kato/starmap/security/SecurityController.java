package dev.hiro.kato.starmap.security;

import dev.hiro.kato.starmap.user.User;
import dev.hiro.kato.starmap.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;


@Controller
public class SecurityController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user) {
        //Save user to db
        String encrypted = passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypted);
        userService.save(user);
        return "redirect:users";
    }

    @GetMapping("/error")
    public String error(){
        return "login_error";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "redirect:users";
    }

}
