package dev.hiro.kato.starmap.apod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/apod")
public interface ApodClient {

    @GetExchange
    Apod fetchApodData(@RequestParam("api_key") String apiKey, @RequestParam("date") String date);

}



