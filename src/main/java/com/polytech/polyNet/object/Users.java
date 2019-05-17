package com.polytech.polyNet.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    public Users() {}

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    public Users(String name) {
        this.username = name;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
