package dev.hiro.kato.starmap.pod;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;

@Controller
public class PodController {

    private final RestClient restClient;
    private final String apiKey;

    public PodController(RestClient restClient, @Value("${nasa.api.key}")  String apiKey) {
        this.restClient = restClient;
        this.apiKey = apiKey;
    }

    @GetMapping("/pod")
    public String getpod(@RequestParam(value = "date", required = false) String date, Model model) {
        if (date == null || date.isEmpty()) {
            date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);  // Use current date if no date is provided
        }

        fetchpodData(date, model);
        return "pod";
    }

    @GetMapping("/pod/random")
    public String getRandompod(Model model) {
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        long randomDays = new Random().nextInt((int) (LocalDate.now().toEpochDay() - startDate.toEpochDay()));
        LocalDate randomDate = startDate.plusDays(randomDays);

        fetchpodData(randomDate.format(DateTimeFormatter.ISO_DATE), model);
        return "pod::#pod-content";  // Partial rendering using HTMX
    }

    private void fetchpodData(String date, Model model) {
        String apiUrl = "https://api.nasa.gov/planetary/pod?api_key=" + apiKey + "&date=" + date;

        try {
            Map<String, Object> podData = restClient
                    .get()
                    .uri(apiUrl)
                    .retrieve()
                    .body(Map.class);

            model.addAttribute("podData", podData);
        } catch (RestClientResponseException e) {
            model.addAttribute("error", "Could not retrieve POD data: " + e.getMessage());
        }
    }
}

