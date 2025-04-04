package id.my.hendisantika.apikeysample.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.filters.apikey")
public class ApiKeyFilterConfig {

    private String pathPrefix;
}
