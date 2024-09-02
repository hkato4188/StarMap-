package dev.hiro.kato.starmap.apod;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApodController {

    private final ApodService apodService;

    public ApodController(ApodService apodService) {
        this.apodService = apodService;
    }

    @GetMapping("/apod")
    public String getpod(Model model) {
        Apod apod = apodService.fetchApodData(false);
        model.addAttribute("apod", apod);
        return "apod";
    }



}

