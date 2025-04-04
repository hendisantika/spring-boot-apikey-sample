package id.my.hendisantika.apikeysample.service;

import com.github.javafaker.Faker;
import id.my.hendisantika.apikeysample.response.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.37
 * To change this template use File | Settings | File Templates.
 */
@Service
public class QuoteService {

    public Response<Map<String, Object>> chuckNorrisFacts() {
        var quote = Faker.instance().chuckNorris().fact();
        return Response.successfulResponse("Operation Successful",
                Map.of("quote", quote));
    }
}
