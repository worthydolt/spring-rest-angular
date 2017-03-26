package net.mashsoftware.infinityworks.service;

import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by neil on 22/03/17.
 */
@Service
public class RatingsRestService {

    private final RestTemplate restTemplate;

    private HttpEntity<String> entity;

    public RatingsRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-version", "2");
        entity = new HttpEntity<>(headers);
    }

    /**
     * Method to make the call to the FHRS API REST service to retrieve the list of all authorities
     * @return a {@link LocalAuthorities} instance which represents the unmarshalled JSON response and contains details of all local authorities available to query through the API
     */
    public LocalAuthorities getAllLocalAuthorities() {
        ResponseEntity<LocalAuthorities> response = this.restTemplate.exchange("http://api.ratings.food.gov.uk/Authorities", HttpMethod.GET, entity, LocalAuthorities.class);
        return response.getBody();
    }

    public
}
