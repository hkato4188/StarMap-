package dev.hiro.kato.starmap.apod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Optional;

@Service
public class ApodService {

    private final ApodClient apodClient;
    private final ApodRepository apodRepository;
    @Value("${nasa.api.key}")
    private String apiKey;


    public ApodService(ApodClient apodClient, ApodRepository apodRepository) {
        this.apodClient = apodClient;
        this.apodRepository = apodRepository;

    }

    public Apod fetchApodData(boolean useRandomDate) {
        String date = useRandomDate ? getRandomDate() : getCurrentDate();
        return apodClient.fetchApodData(apiKey, date);
    }

    private String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    private String getRandomDate() {
        LocalDate start = LocalDate.of(2001, 1, 1);
        long days = start.until(LocalDate.now()).getDays();
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days));
        return randomDate.format(DateTimeFormatter.ISO_DATE);
    }

    public Apod getApodByDate(String date) {
        return apodRepository.findByDate(date);
    }

}