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
 * Created by neil on 11/03/17.
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
        int totalEstablishments = establishments.getEstablishments().size();
        Stream<Establishment> establishmentStream = establishments.getEstablishments().stream();
        Map<String, Long> ratingsGroupedByCount = establishmentStream.collect(Collectors.groupingBy(Establishment::getRatingValue, counting()));
        return ratingsGroupedByCount;
    }
}