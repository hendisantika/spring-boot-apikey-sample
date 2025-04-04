package id.my.hendisantika.apikeysample.controller;

import id.my.hendisantika.apikeysample.config.Routes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

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
 * Time: 06.52
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class QuoteControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenValidAPIKey_whenFamousQuotes_thenReturnSuccess() throws Exception {
        String apiKey = "5c8d56a2-88b2-48a7-aec8-c9a8ac7af99a";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Api-Key", apiKey);

        mvc.perform(MockMvcRequestBuilders.get(Routes.QUOTES).headers(httpHeaders))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", equalTo(200)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", equalTo(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", equalTo("Operation Successful")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.quote", notNullValue()));
    }

    @Test
    public void givenInvalidAPIKey_whenFamousQuotes_thenReturnUnauthorized() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Api-Key", UUID.randomUUID() + "100");

        mvc.perform(MockMvcRequestBuilders.get(Routes.QUOTES).headers(httpHeaders))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

}
