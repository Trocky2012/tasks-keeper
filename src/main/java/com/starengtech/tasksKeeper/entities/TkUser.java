package com.starengtech.tasksKeeper.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_tkuser")
public class TkUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;
    private String fName;
    private String lName;
    private String country;

    @Column(name = "email", nullable = false)
    private String email;
    private String password;
    private boolean flActive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant lastLoginTime;

    @JsonIgnore
    @OneToMany(mappedBy = "tkUser")
    private List<TkSection> sections = new ArrayList<>();


    public TkUser() {
    }

    public TkUser(Long id, String fName, String lName, String email, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.flActive = true;
    }
    public TkUser(Long id, String fName, String lName, String email, String password, String country) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.flActive = true;
    }
    public TkUser(Long id, String fName, String lName, String email, String password, String country, List<TkSection> sections) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.sections = sections;
        this.country = country;
        this.flActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlActive() {
        return flActive;
    }

    public void setFlActive(boolean flActive) {
        this.flActive = flActive;
    }

    public Instant getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Instant lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<TkSection> getSections(){ return sections; }

    public void setSections(List<TkSection> sections) {
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkUser profile = (TkUser) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
