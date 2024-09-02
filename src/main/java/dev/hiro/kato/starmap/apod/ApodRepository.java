package dev.hiro.kato.starmap.apod;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ApodRepository extends JpaRepository<Apod, Long> {

    Apod findByDate(String date);
}
