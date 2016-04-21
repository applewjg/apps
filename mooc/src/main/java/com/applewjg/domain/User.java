package com.applewjg.domain;

import javax.persistence.*;

/**
 * Created by baidu on 16/4/12.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "username", nullable = false, length = 64)
    private String username = "";

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password = "";

    @Basic
    @Column(name = "email", nullable = false, length = 64)
    private String email = "";

    @Basic
    @Column(name = "tel", nullable = false, length = 64)
    private String tel = "";

    public User() {}

    public User(String username, String password, String email, String tel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
