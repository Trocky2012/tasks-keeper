package com.starengtech.tasksKeeper.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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

    private List<TkNote> notes = new ArrayList<>();

    public TkSectionDTO() {
    }

    public TkSectionDTO(TkSection section){
        this.id = section.getId();
        this.title = section.getTitle();
        this.insertTime = section.getInsertTime();
        this.notes = section.getNotes();
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

    public List<TkNote> getNotes() {
        return notes;
    }

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
