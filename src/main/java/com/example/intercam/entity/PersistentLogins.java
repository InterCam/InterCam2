package com.example.intercam.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "persistent_logins")
@Getter
public class PersistentLogins {
    @Id
    @Column(length = 64)
    private String series;

    @Column(nullable = false,length = 64)
    private String username;

    @Column(nullable = false, length = 64)
    private String token;

    @Column(name="last_used", nullable = false, length = 64)
    private LocalDateTime lastUsed;
}