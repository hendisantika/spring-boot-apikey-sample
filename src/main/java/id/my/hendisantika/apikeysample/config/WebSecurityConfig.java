package id.my.hendisantika.apikeysample.config;

import id.my.hendisantika.apikeysample.helper.ClientAuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.38
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final ClientAuthenticationHelper authServiceHelper;
    private final ApiKeyFilterConfig config;

}
