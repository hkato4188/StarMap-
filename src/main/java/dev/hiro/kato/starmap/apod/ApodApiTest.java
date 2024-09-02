package dev.hiro.kato.starmap.apod;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApodApiTest {


    private ApodService apodService;

    public ApodApiTest(ApodService apodService) {
        this.apodService = apodService;
    }

    @Test
    void testPodService(){
        Apod mockApod = new Apod();
        mockApod.setTitle("A Triangular Prominence Hovers Over the Sun");
        mockApod.setDate("2024-09-02");
        mockApod.setExplanation("Why is there a triangle hovering over the Sun? Although the shape is unusual, the type of structure is not: it is part of an evolving solar prominence...");
        mockApod.setHdurl("https://apod.nasa.gov/apod/image/2409/SunTriangle_Vanoni_960.jpg");
        mockApod.setMediaType("image");
        mockApod.setServiceVersion("v1");
        mockApod.setUrl("https://apod.nasa.gov/apod/image/2409/SunTriangle_Vanoni_960.jpg");
        mockApod.setCopyright("\nAndrea Vanoni\n");

        // Mock the behavior of the service
        Mockito.when(apodService.fetchApodData(false)).thenReturn(mockApod);

        // Call the method to test
        Apod apod = apodService.fetchApodData(false);

        // Validate the result
        assertEquals("A Triangular Prominence Hovers Over the Sun", apod.getTitle());

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