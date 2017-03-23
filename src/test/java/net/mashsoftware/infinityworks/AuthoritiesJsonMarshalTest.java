package net.mashsoftware.infinityworks;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import net.mashsoftware.infinityworks.dto.LocalAuthority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test marshal and unmarshal of Authorities JSON. We use a chunk of sample JSON retrieved from the REST
 * service in files in the resources directory and attempt to unmarshal the JSON therein. We also use these files
 * to compare to the results of doing a marshal on the {@link LocalAuthorities} instance we create
 */
@RunWith(SpringRunner.class)
@JsonTest
public class AuthoritiesJsonMarshalTest {

    @Autowired private JacksonTester<LocalAuthorities> jsonArrayParser;

    @Test
    public void testSerialize() throws Exception{
        LocalAuthority authority = buildLocalAuthority();
        List<LocalAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        LocalAuthorities authoritiesWrapper = new LocalAuthorities();
        authoritiesWrapper.setLocalAuthorities(authorities);
        String json = new String(Files.readAllBytes(Paths.get("src/test/resources/single-authority.json")));
        assertThat(jsonArrayParser.write(authoritiesWrapper)).isEqualToJson(json);

    }

    @Test
    public void testDeserialize() throws Exception{
        String json = new String(Files.readAllBytes(Paths.get("src/test/resources/authorities.json")));
        ObjectContent<LocalAuthorities> authorities = jsonArrayParser.parse(json);
        //ensure some degree of success from unmarshal
        assertThat(authorities).isNotNull();
        // ensure that every field was unmarshalled
        assertTrue(EqualsBuilder.reflectionEquals(authorities.getObject().getLocalAuthorities().get(0), buildLocalAuthority()));
    }

    /*
    Helper to build a LocalAuthority instance which we can use to test marshalling and unmarshalling to and from JSON
     */
    private LocalAuthority buildLocalAuthority(){
        LocalAuthority authority = new LocalAuthority();
        authority.setCreationDate("2010-08-17T15:30:24.87");
        authority.setLastPublishedDate("2017-03-21T00:32:35.593");
        authority.setLocalAuthorityId(197);
        authority.setLocalAuthorityIdCode("760");
        authority.setUrl("http://www.aberdeencity.gov.uk");
        authority.setSchemeUrl("");
        authority.setSchemeType(2);
        authority.setEmail("commercial@aberdeencity.gov.uk");
        authority.setEstablishmentCount(1759);
        authority.setFriendlyName("aberdeen-city");
        authority.setName("Aberdeen City");
        authority.setRegionName("Scotland");
        authority.setFileName("http://ratings.food.gov.uk/OpenDataFiles/FHRS760en-GB.xml");
        Map<String, String> links = new HashMap<>();
        links.put("rel", "self");
        links.put("href", "http://api.ratings.food.gov.uk/authorities/197");
        List<Map<String, String>> linksList = new ArrayList<>();
        linksList.add(links);
        authority.setLinks(linksList);
        return authority;
    }


}
