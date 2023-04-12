package com.starengtech.tasksKeeper.repositories;

import com.starengtech.tasksKeeper.entities.TkUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TkUserRepository extends JpaRepository<TkUser, Long> {
    Optional<TkUser> findByEmail(String email);
    Optional<TkUser> findByEmailAndPassword(String email, String password);
}
