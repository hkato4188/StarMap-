package dev.hiro.kato.starmap;

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
public class NasaTest {

    //retrieve the hard coded api response
    @Value("classpath:data/nasa-pod.json")
    //resource inherits from resource stream
    Resource nasaPodJson;

    //Autowire ObjectMapper from Jackson
    @Autowired
    ObjectMapper objectMapper;
    //String variant of the file
    String fileJson;

    //Context load so that what we need (objectMapper) in the test is available
    @Test
    void contextLoda(){
        assertNotNull(objectMapper);
    }

    //Setup method to convert json to string so we don't have to read the file for each test
    @BeforeEach
    void setUp() throws IOException {
        fileJson = new String(Files.readAllBytes(nasaPodJson.getFile().toPath()));
        objectMapper.readValue(fileJson, );
    }



}



