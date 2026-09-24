package com.example.scoreapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "api_user")
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true, nullable = false)
    private String userToken;

    private boolean active;

    public ApiUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserToken() {
        return userToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}