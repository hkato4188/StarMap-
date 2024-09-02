package dev.hiro.kato.starmap.apod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApodClientConfig {

    @Bean
    ApodClient apodClient() {
        RestClient restClient = RestClient.create("https://api.nasa.gov/planetary");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(ApodClient.class);
    }
}
