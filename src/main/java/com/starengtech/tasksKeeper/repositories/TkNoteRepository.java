package com.starengtech.tasksKeeper.repositories;

import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TkNoteRepository extends JpaRepository<TkNote, Long> {
    Optional<TkNote> findByTitle(String title);
    List<TkNote> findByTkSection(TkSection tkSection);
    List<TkNote> findByUserId(Long userId);
}
