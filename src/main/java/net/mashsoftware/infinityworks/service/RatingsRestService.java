package net.mashsoftware.infinityworks.service;

import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by neil on 22/03/17.
 */
@Service
public class RatingsRestService {

    private final RestTemplate restTemplate;

    public RatingsRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public LocalAuthorities getAllLocalAuthorities() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-version", "2");
        HttpEntity<LocalAuthorities> entity = new HttpEntity<>(headers);
        return this.restTemplate.getForObject("http://api.ratings.food.gov.uk/Authorities", LocalAuthorities.class);
    }
}
