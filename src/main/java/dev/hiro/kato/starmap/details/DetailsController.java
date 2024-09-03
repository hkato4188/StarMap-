package dev.hiro.kato.starmap.details;

import dev.hiro.kato.starmap.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DetailsController {

    @GetMapping("/")
    public String showAbout(Model model) {
        return "details/about";
    }

}
