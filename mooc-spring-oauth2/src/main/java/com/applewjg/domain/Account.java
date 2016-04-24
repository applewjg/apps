package com.applewjg.domain;

import javax.persistence.*;

/**
 * Created by baidu on 16/4/12.
 */
@Entity
@Table(name = "Account",
        indexes = {@Index(name = "username",columnList = "username")
        }
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 64, unique = true)
    private String username = "";

    @Column(name = "password", nullable = false, length = 64)
    private String password = "";

    @Column(name = "email", nullable = false, length = 64, columnDefinition = "varchar(64) not null default ''")
    private String email = "";

    @Column(name = "tel", nullable = false, length = 64, columnDefinition = "varchar(64) not null default ''")
    private String tel = "";

    @Column(name = "role", nullable = false, columnDefinition = "int not null default 0")
    private Integer role = 0;

    public Account() {}

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
