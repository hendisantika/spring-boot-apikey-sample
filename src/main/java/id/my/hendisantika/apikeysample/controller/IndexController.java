package id.my.hendisantika.apikeysample.controller;

import id.my.hendisantika.apikeysample.config.Routes;
import id.my.hendisantika.apikeysample.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.39
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class IndexController {

    @GetMapping(Routes.WEB_INDEX)
    public ResponseEntity<Response<Map<String, Long>>> index() {
        var response = Response.successfulResponse("Welcome to Bandung",
                Map.of("timestamp", System.currentTimeMillis()));
        return ResponseEntity.status(response.getCode())
                .body(response);
    }
}
