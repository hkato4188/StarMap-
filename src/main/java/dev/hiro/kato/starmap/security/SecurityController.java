package dev.hiro.kato.starmap.security;

import dev.hiro.kato.starmap.user.User;
import dev.hiro.kato.starmap.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        return "security/registration";
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

        return "security/error";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            return "redirect:users";
        }

        model.addAttribute("user", new User());
        return "security/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "redirect:users";
    }

}
