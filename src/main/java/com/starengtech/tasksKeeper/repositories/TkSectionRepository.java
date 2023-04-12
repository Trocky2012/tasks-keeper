package com.starengtech.tasksKeeper.repositories;

import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TkSectionRepository extends JpaRepository<TkSection, Long> {
    Optional<TkSection> findByTitle(String title);
    List<TkSection> findByTkUser(TkUser tkUser);
}
