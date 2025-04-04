package id.my.hendisantika.apikeysample.config;

import id.my.hendisantika.apikeysample.filter.ApiKeyFilter;
import id.my.hendisantika.apikeysample.helper.ClientAuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //add the ApiKeyFilter to the security chain
        http.addFilterBefore(new ApiKeyFilter(authServiceHelper, config),
                AnonymousAuthenticationFilter.class);

        //configure the security chain to authenticate all endpoints
        //except the /error
        http.authorizeHttpRequests(requests ->
                requests.requestMatchers(new AntPathRequestMatcher("/error")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher(Routes.WEB_INDEX)).permitAll()
                        .anyRequest().authenticated()
        );

        //since this is an API, configure it to be stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
