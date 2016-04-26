package com.applewjg.repository;

import com.applewjg.domain.Oauth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baidu on 16/4/25.
 */
@Repository
public interface Oauth2ClientRepository extends JpaRepository<Oauth2Client, Long> {
    Oauth2Client findByClientid(String clientid);
    Oauth2Client findByClientsecret(String clientsecret);
}
