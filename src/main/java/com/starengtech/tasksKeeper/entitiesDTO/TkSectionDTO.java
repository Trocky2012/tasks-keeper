package com.starengtech.tasksKeeper.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


public class TkSectionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant insertTime;

    /*@ManyToOne
    @JoinColumn(name = "userId")
    private TkUser tkUser;*/

    public TkSectionDTO() {
    }

    public TkSectionDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public TkSectionDTO(TkSection tksection){
        this.id = tksection.getId();
        this.title = tksection.getTitle();
        this.insertTime = tksection.getInsertTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    /*public TkUser getTkUser() {
        return tkUser;
    }

    public void setTkUser(TkUser tkUser) {
        this.tkUser = tkUser;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkSectionDTO profile = (TkSectionDTO) o;
        return id.equals(profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
