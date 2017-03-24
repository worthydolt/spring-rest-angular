package net.mashsoftware.infinityworks;

import net.mashsoftware.infinityworks.dto.LocalAuthorities;
import net.mashsoftware.infinityworks.service.RatingsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.callback.LanguageCallback;
import java.util.ArrayList;
import java.util.List;

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

}