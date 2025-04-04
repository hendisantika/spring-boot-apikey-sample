package id.my.hendisantika.apikeysample.controller;

import id.my.hendisantika.apikeysample.config.Routes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.50
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void whenIndex_thenReturnSuccess() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get(Routes.WEB_INDEX))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", equalTo(200)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", equalTo(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", equalTo("Welcome to SMATTME")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.timestamp", notNullValue()));

    }

}
