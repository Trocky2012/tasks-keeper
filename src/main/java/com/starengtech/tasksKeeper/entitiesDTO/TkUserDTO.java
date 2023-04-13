package com.starengtech.tasksKeeper.entitiesDTO;

import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TkUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long projectId;
    private String fName;
    private String lName;
    private String email;
    private String country;
    private String password;
    private boolean flActive;

    private List<TkSection> sections = new ArrayList<>();


    public TkUserDTO() {
    }

    public TkUserDTO(TkUser tkuser){
        this.id = tkuser.getId();
        this.projectId = tkuser.getProjectId();
        this.fName = tkuser.getfName();
        this.lName = tkuser.getlName();
        this.email = tkuser.getEmail();
        this.country = tkuser.getCountry();
        this.password = tkuser.getPassword();
        this.flActive = tkuser.isFlActive();
        this.sections = tkuser.getSections();
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public boolean isFlActive() {
        return flActive;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public List<TkSection> getSections() {
        return sections;
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
