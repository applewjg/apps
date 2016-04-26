package com.applewjg.domain;

import javax.persistence.*;

/**
 * Created by baidu on 16/4/25.
 *
 */
@Entity
public class Oauth2Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "clientname", nullable = false, length = 128, unique = true)
    private String clientname = "";

    @Column(name = "clientsecret", nullable = false, length = 128, unique = true)
    private String clientsecret = "";


    @Column(name = "clientid", nullable = false, length = 128, unique = true)
    private String clientid = "";

    public Oauth2Client() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientsecret() {
        return clientsecret;
    }

    public void setClientsecret(String clientsecret) {
        this.clientsecret = clientsecret;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }
}
