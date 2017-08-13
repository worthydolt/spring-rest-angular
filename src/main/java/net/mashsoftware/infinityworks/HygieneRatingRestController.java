package net.mashsoftware.infinityworks;

import net.mashsoftware.infinityworks.dto.Establishment;
import net.mashsoftware.infinityworks.dto.Establishments;
import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import net.mashsoftware.infinityworks.service.RatingsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.callback.LanguageCallback;
import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * A controller to provide services to our front-end application. When the front-end requires data it calls down to here.
 * We try to keep as little code as we can get away with in the front-end as a Java application is easier to test and
 * easier to scale
 */
@RestController
public class HygieneRatingRestController {

    @Autowired RatingsRestService service;

    @RequestMapping("/app/rest/allAuthorities")
    public LocalAuthorities getAllAuthorities() {
        return service.getAllLocalAuthorities();
    }

    @RequestMapping("/app/rest/authorityEstablishments")
    public Map<String, Long> getAuthorityEstablishments(@RequestParam String authorityId) {
        Establishments establishments = service.getEstablishmentsForAuthority(authorityId);
        Stream<Establishment> establishmentStream = establishments.getEstablishments().stream();
        Map<String, Long> ratingsGroupedByCount = establishmentStream.collect(Collectors.groupingBy(Establishment::getRatingValue, counting()));
        return ratingsGroupedByCount;
    }
}