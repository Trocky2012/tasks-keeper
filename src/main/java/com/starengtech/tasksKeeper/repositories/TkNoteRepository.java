package com.starengtech.tasksKeeper.repositories;

import com.starengtech.tasksKeeper.entities.TkNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TkNoteRepository extends JpaRepository<TkNote, Long> {
    Optional<TkNote> findByTitle(String title);
}
