package net.mashsoftware.infinityworks;

import net.mashsoftware.infinityworks.dto.Establishments;
import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import net.mashsoftware.infinityworks.service.RatingsRestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Test the service class that handles interactions with the REST service and returns POJOs to us
 */
@RunWith(SpringRunner.class)
@RestClientTest(RatingsRestService.class)
public class HygieneRatingRestControllerTest {

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    RatingsRestService ratingsRestService;

    private String authoritiesListJson;
    private String scottishEstablishmentsListJson;
    private String englishEstablishmentsListJson;

    @Before
    public void setup() throws Exception {
        authoritiesListJson = new String(Files.readAllBytes(Paths.get("src/test/resources/single-authority.json")));
        scottishEstablishmentsListJson = new String(Files.readAllBytes(Paths.get("src/test/resources/scottish-establishments.json")));
        englishEstablishmentsListJson = new String(Files.readAllBytes(Paths.get("src/test/resources/english-establishments.json")));
    }

    /*
    Ensure that a GET request to the Authorities api is made. If we see this then the mock server returns a success
    status and a JSON body containing one authority only. This should be unmarshalled but we don't probe too deeply
     as unmarshalling is tested more thoroughly in AuthoritiesJsonMarshalTest
     */
    @Test
    public void getAllAuthoritiesTest() throws Exception {
        mockRestServiceServer.expect(requestTo(RatingsRestService.REST_API_URL_FOR_LIST_OF_AUTHORITIES))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("x-api-version", "2"))
                .andRespond(withSuccess(authoritiesListJson, MediaType.APPLICATION_JSON));
        LocalAuthorities unmarshalBody = ratingsRestService.getAllLocalAuthorities();
        assertNotNull(unmarshalBody);
        assertEquals("Expected to find one authority in REST response", 1, unmarshalBody.getLocalAuthorities().size());
        mockRestServiceServer.verify();
    }

    /*
    Ensure that the call to get the establishments for a given Scottish authority is successful and that we can unmarshal the response
     */
    @Test
    public void getScottishAuthorityEstablishmentsTest() throws Exception {
        mockRestServiceServer.expect(requestTo(String.format(RatingsRestService.REST_API_URL_FOR_LIST_OF_ESTABLISHMENTS_BY_AUTHORITY, "666")))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("x-api-version", "2"))
                .andRespond(withSuccess(scottishEstablishmentsListJson, MediaType.APPLICATION_JSON));
        Establishments unmarshalBody = ratingsRestService.getEstablishmentsForAuthority("666");
        assertNotNull(unmarshalBody);
        assertEquals(3, unmarshalBody.getEstablishments().size());
    }

    /*
   Ensure that the call to get the establishments for a given English authority is successful and that we can unmarshal the response.
   It shouldn't be any different from the Scottish establishments since the rating value is simply a string, but it's easy to do and insulates us
    */
    @Test
    public void getEnglishAuthorityEstablishmentsTest() throws Exception {
        mockRestServiceServer.expect(requestTo(String.format(RatingsRestService.REST_API_URL_FOR_LIST_OF_ESTABLISHMENTS_BY_AUTHORITY, "1000")))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("x-api-version", "2"))
                .andRespond(withSuccess(englishEstablishmentsListJson, MediaType.APPLICATION_JSON));
        Establishments unmarshalBody = ratingsRestService.getEstablishmentsForAuthority("1000");
        assertNotNull(unmarshalBody);
        assertEquals(5, unmarshalBody.getEstablishments().size());
    }

    @Test
    public void getEstablishmentsThrowsBadRequestException(){
        try {
            mockRestServiceServer.expect(requestTo(RatingsRestService.REST_API_URL_FOR_LIST_OF_AUTHORITIES))
                    .andExpect(method(HttpMethod.GET))
                    .andExpect(header("x-api-version", "2"))
                    .andRespond(withBadRequest());

            LocalAuthorities response = ratingsRestService.getAllLocalAuthorities();
            assertNotNull(response);
        } catch (Exception e) {
            fail("Should not have thrown exception");
        }
    }

    @Test
    public void getEstablishmentsThrowsTimeoutException(){
        try {
            mockRestServiceServer.expect(requestTo(RatingsRestService.REST_API_URL_FOR_LIST_OF_AUTHORITIES))
                    .andExpect(method(HttpMethod.GET))
                    .andExpect(header("x-api-version", "2"))
                    .andRespond(withBadRequest());

            LocalAuthorities response = ratingsRestService.getAllLocalAuthorities();
            assertNotNull(response);
        } catch (Exception e) {
            fail("Should not have thrown exception");
        }
    }
}