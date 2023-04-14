package com.starengtech.tasksKeeper.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_tksection")
public class TkSection implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant insertTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    private TkUser tkUser;

    @JsonIgnore
    @OneToMany(mappedBy = "section")
    private List<TkNote> notes = new ArrayList<>();

    public TkSection() {
    }

    public TkSection(Long id, String title,TkUser tkUser ) {
        this.id = id;
        this.title = title;
        this.tkUser = tkUser;
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

    public TkUser getTkUser() {
        return tkUser;
    }

    public void setTkUser(TkUser tkUser) {
        this.tkUser = tkUser;
    }

    public List<TkNote> getNotes() {
        return notes;
    }

    public void setNotes(List<TkNote> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkSection profile = (TkSection) o;
        return id.equals(profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
