package com.starengtech.tasksKeeper.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.TkUser;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TkUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "email", nullable = false)
    private String email;
    private String password;
    private boolean flActive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant lastLoginTime;

    public TkUserDTO() {
    }

    public TkUserDTO(TkUser profile){
        this.name = profile.getName();
        this.email = profile.getEmail();
        this.password = profile.getPassword();
    }

    public TkUserDTO(String name, String email, String password, String nationality) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isFlActive() {
        return flActive;
    }

    public Instant getLastLoginTime() {
        return lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkUserDTO profile = (TkUserDTO) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
