package dev.hiro.kato.starmap.apod;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Apod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String copyright;
    @Column(unique = true)
    private String date;
    @Column
    private String explanation;
    @Column
    private String hdurl;
    @Column
    private String mediaType;
    @Column
    private String serviceVersion;
    @Column
    private String title;
    @Column
    private String url;


}

