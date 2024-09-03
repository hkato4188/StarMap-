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

    public Apod fetchApodDataByDate(String date) {
        return apodClient.fetchApodData(apiKey, date);
    }

    private String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    private String getRandomDate() {
        Random random = new Random();
        LocalDate start = LocalDate.of(2001, 1, 1);
        LocalDate end = LocalDate.now();
        // Calculate the number of days between the start and end dates
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(start, end);
        // Generate a random number of days to add to the start date
        long randomDays = random.nextLong(daysBetween + 1);
        // Create the random date
        LocalDate randomDate = start.plusDays(randomDays);
        // Format the date as "YYYY-MM-DD"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }



}