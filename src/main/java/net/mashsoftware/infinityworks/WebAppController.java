package net.mashsoftware.infinityworks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The simplest of controllers which provides the app's entry point, serving the index page
 */
@Controller
public class WebAppController {

    @RequestMapping("/")
    public String index() {
        return "app/index.html";
    }


}
