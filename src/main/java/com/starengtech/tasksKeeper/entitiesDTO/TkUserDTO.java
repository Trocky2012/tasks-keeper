package com.starengtech.tasksKeeper.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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

    //private List<TkSection> sections = new ArrayList<>();


    public TkUserDTO() {
    }

    public TkUserDTO(TkUser tkuser){
        this.id = tkuser.getId();
        this.name = tkuser.getFName();
        this.email = tkuser.getEmail();
        this.password = tkuser.getPassword();
        this.flActive = tkuser.isFlActive();
    }

    public TkUserDTO(String name, String email) {
        this.name = name;
        this.email = email;
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
