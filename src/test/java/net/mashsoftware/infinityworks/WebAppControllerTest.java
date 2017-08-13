package net.mashsoftware.infinityworks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for the web-app controller. We expect this to serve HTML pages according to the URL requested.
 * REST calls are tested in {@link HygieneRatingRestControllerTest}
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WebAppController.class)
public class WebAppControllerTest {

    @Autowired private WebAppController webAppController;

    @Autowired private MockMvc mockMvc;

    @Test
    public void index() throws Exception {
        assertNotNull(webAppController);
        this.mockMvc.perform(get("/app/index.html"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Restaurant")));
    }

}