package com.starengtech.tasksKeeper.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.tasksKeeper.entities.Enum.NoteStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_tknote")
public class TkNote implements Serializable {
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant insertTime;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private TkSection section;

    public TkNote() {
    }

    public TkNote(Long id, Long userId, String date, String title, TkSection tkSection ) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.title = title;
        this.section = tkSection;
        this.noteStatus = NoteStatus.ACTIVE;
        this.sectionTitle = tkSection.getTitle();
    }

    public TkNote(Long id, Long userId, String date, String title, TkSection tkSection, String sectionTitle) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.title = title;
        this.section = tkSection;
        this.noteStatus = NoteStatus.ACTIVE;
        this.sectionTitle = sectionTitle;
    }

    public TkNote(Long id, Long userId, String date, String title, String content, TkSection tkSection ) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.content = content;
        this.title = title;
        this.section = tkSection;
        this.noteStatus = NoteStatus.ACTIVE;
        this.sectionTitle = tkSection.getTitle();
    }


    public TkNote(Long id, Long userId, String date, String title, String content, TkSection tkSection, String sectionTitle) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.content = content;
        this.title = title;
        this.section = tkSection;
        this.noteStatus = NoteStatus.ACTIVE;
        this.sectionTitle = sectionTitle;
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

    public NoteStatus getNoteStatus() {
        return noteStatus;
    }

    public void setNoteStatus(NoteStatus noteStatus) {
        this.noteStatus = noteStatus;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    public TkSection getSection() {
        return section;
    }

    public void setSection(TkSection section) {
        this.section = section;
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TkNote profile = (TkNote) o;
        return id.equals(profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
