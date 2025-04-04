package id.my.hendisantika.apikeysample.repository;

import id.my.hendisantika.apikeysample.entity.ClientCredential;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

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
public interface ClientCredentialRepository extends CrudRepository<ClientCredential, Integer> {

    Optional<ClientCredential> findByApiKey(String apiKey);
}
