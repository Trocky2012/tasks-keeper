package com.starengtech.tasksKeeper.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.Enum.NoteStatus;
import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TkNoteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String date;
    private String sectionTitle;
    private NoteStatus noteStatus;
    private TkSection section;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant insertTime;


    public TkNoteDTO() {
    }

    public TkNoteDTO(TkNote tknote){
        this.id = tknote.getId();
        this.userId = tknote.getUserId();
        this.date = tknote.getDate();
        this.sectionTitle = tknote.getSectionTitle();
        this.title = tknote.getTitle();
        this.content = tknote.getContent();
        this.noteStatus=tknote.getNoteStatus();
        this.insertTime = tknote.getInsertTime();
        this.section= tknote.getSection();
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public NoteStatus getNoteStatus() {
        return noteStatus;
    }

    public TkSection getSection() {
        return section;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkNoteDTO profile = (TkNoteDTO) o;
        return id.equals(profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
