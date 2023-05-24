package com.example.entity;

import io.micronaut.data.annotation.DateCreated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class RefreshTokenEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String userId;

    private String refreshToken;

    private Boolean revoked;

    @DateCreated
    private Instant dateCreated;

    public RefreshTokenEntity() {
    }

    public RefreshTokenEntity(String username, String userId, String refreshToken, Boolean revoked) {
        this.username = username;
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.revoked = revoked;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }
}
