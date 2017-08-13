package net.mashsoftware.infinityworks.service;

import net.mashsoftware.infinityworks.dto.Establishments;
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
 * A service class to handle all interactions with the Food Standards Agency API service
 */
@Service
public class RatingsRestService {

    public static final String REST_API_URL_FOR_LIST_OF_AUTHORITIES = "http://api.ratings.food.gov.uk/Authorities";
    public static final String REST_API_URL_FOR_LIST_OF_ESTABLISHMENTS_BY_AUTHORITY = "http://api.ratings.food.gov.uk/Establishments?localAuthorityId=%s&pageSize=0";
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
     *
     * @return a {@link LocalAuthorities} instance which represents the unmarshaled JSON response and contains details of all local authorities available to query through the API
     */
    public LocalAuthorities getAllLocalAuthorities() {
        ResponseEntity<LocalAuthorities> response = restTemplate.exchange(REST_API_URL_FOR_LIST_OF_AUTHORITIES, HttpMethod.GET, entity,
                LocalAuthorities.class);
        return response.getBody();
    }

    /**
     * Method to retrieve the list of establishments (with associated rating) belonging to the authority identified by the localAuthorityId parameter.
     * @param localAuthorityId the ID of the local authority to get the list of rated establishments for
     * @return an {@link Establishments} instance
     */
    public Establishments getEstablishmentsForAuthority(String localAuthorityId) {
        ResponseEntity<Establishments> response = restTemplate.exchange(String.format(REST_API_URL_FOR_LIST_OF_ESTABLISHMENTS_BY_AUTHORITY,
                localAuthorityId), HttpMethod.GET, entity, Establishments.class);
        return response.getBody();
    }
}
