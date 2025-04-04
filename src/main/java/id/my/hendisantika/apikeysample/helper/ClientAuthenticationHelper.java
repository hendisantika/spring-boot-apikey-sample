package id.my.hendisantika.apikeysample.helper;

import id.my.hendisantika.apikeysample.repository.ClientCredentialRepository;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.36
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ClientAuthenticationHelper {

    private final ClientCredentialRepository clientCredentialRepository;

    public ClientAuthenticationHelper(ClientCredentialRepository clientCredentialRepository) {
        this.clientCredentialRepository = clientCredentialRepository;
    }

    public boolean validateApiKey(String requestApiKey) {
        //this is a simplistic implementation. Prod
        //implementation will check for expired key and other business logic
        var optionalClientCred = clientCredentialRepository.findByApiKey(requestApiKey);
        return optionalClientCred.isPresent();
    }
}
