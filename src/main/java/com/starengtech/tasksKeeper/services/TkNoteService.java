package com.starengtech.tasksKeeper.services;

import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.repositories.TkNoteRepository;
import com.starengtech.tasksKeeper.services.exceptions.DatabaseException;
import com.starengtech.tasksKeeper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TkNoteService {

    @Autowired
    private TkNoteRepository repository;

    public List<TkNote> findAll() {
        return repository.findAll();
    }

    public Optional<TkNote>  findById(Long id) {
        try{
            return repository.findById(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Optional<TkNote> findByTitle(String title) {
        try{
            return repository.findByTitle(title);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public TkNote insert(TkNote note) {
        note.setInsertTime(Instant.now());
        note.setSectionTitle(note.getSectionTitle());
        return repository.save(note);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public TkNote update(Long id, TkNote section) {
        try {
            TkNote entity = repository.getById(id);
            entity.setTitle(section.getTitle());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //-------------

    public List<TkNote> findBySection(TkSection section){
        return repository.findBySection(section);
    }
    public List<TkNote> findByUserId(Long id){
        return repository.findByUserId(id);
    }

}
