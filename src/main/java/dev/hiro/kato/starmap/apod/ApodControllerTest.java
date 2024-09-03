package dev.hiro.kato.starmap.apod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@JsonTest
class ApodControllerTest {

    @Value("classpath:data/nasa-pod.json")
    Resource blogPostsJson;

    @Autowired
    ObjectMapper objectMapper;

    String json;

    @Test
    void contextLoads() {
        assertNotNull(objectMapper);
    }

    @BeforeEach
    void setUp() throws IOException {
        json = new String(Files.readAllBytes(blogPostsJson.getFile().toPath()));
        var apod = objectMapper.readValue(json, Apod.class);
        System.out.print(apod.toString());

    }
}
//{
//        "copyright": "\nAndrea Vanoni\n",
//        "date": "2024-09-02",
//        "explanation": "Why is there a triangle hovering over the Sun?  Although the shape is unusual, the type of structure is not: it is part of an evolving solar prominence.  Looping magnetic fields on the Sun channel the flow of energetic particles, sometimes holding glowing gaseous structures aloft for months.  A prominence glows brightly because it contains particularly hot, dense, or opaque solar plasma. The surprising triangular structure occurred last week. Larger than our Earth, the iconic prominence was imaged by several solar photographers and documented by NASA's Solar Dynamic Observatory to form and violently dissipate in about a day. The featured image was captured in a color of red light emitted strongly by hydrogen.  Below, solar fibrils carpet the Sun's chromosphere, while the background sky is so faint in comparison that no stars are visible.  Our Sun's surface has been quite active this year.",
//        "hdurl": "https://apod.nasa.gov/apod/image/2409/SunTriangle_Vanoni_960.jpg",
//        "media_type": "image",
//        "service_version": "v1",
//        "title": "A Triangular Prominence Hovers Over the Sun",
//        "url": "https://apod.nasa.gov/apod/image/2409/SunTriangle_Vanoni_960.jpg"
//        }