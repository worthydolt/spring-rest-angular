package net.mashsoftware.infinityworks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neil on 11/03/17.
 */
@Controller
public class WebAppController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
