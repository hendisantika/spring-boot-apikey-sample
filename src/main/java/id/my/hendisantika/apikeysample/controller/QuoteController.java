package id.my.hendisantika.apikeysample.controller;

import id.my.hendisantika.apikeysample.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.40
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

}
