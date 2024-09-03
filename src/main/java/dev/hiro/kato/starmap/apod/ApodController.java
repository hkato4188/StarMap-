package dev.hiro.kato.starmap.apod;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/apod/random")
    public String getRandomPod(Model model) {
        Apod apod = apodService.fetchApodData(true);
        model.addAttribute("apod", apod);
        return "apod";
    }

    @GetMapping("/apod/search")
    public String showSearchForm(Model model) {
        // No need to add any data to the model for this form
        return "apod_search"; // Template name
    }

    @PostMapping("/apod/date")
    public String getPodByDate(@RequestParam("date") String date, Model model) {
        // Fetch the APOD data for the specified date
        Apod apod = apodService.fetchApodDataByDate(date);

        // Add the APOD and date to the model
        model.addAttribute("apod", apod);
        model.addAttribute("date", date);

        // Return the view to display the APOD
        return "apod"; // Template to show the APOD result
    }



}

