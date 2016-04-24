package com.applewjg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by baidu on 16/4/24.
 */
@Entity
public class AccountRole {
    @Id
    @Column(columnDefinition = "int(11) not null")
    private Long id;

    @Column(length = 64, nullable = false)
    private String role;

    public AccountRole() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
