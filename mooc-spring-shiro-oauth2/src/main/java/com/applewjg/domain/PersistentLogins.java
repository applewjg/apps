package com.applewjg.domain;

import javax.persistence.*;

/**
 * Created by baidu on 16/4/22.
 */
@Entity
public class PersistentLogins {
    @Id
    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "username", nullable = false, length = 64)
    private String username = "";

    @Column(name = "token", nullable = false, length = 64)
    private String token = "";

    @Column(name = "lastUsed", nullable = false)
    private Long lastUsed= 0L;

    public PersistentLogins() {}

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Long lastUsed) {
        this.lastUsed = lastUsed;
    }
}
