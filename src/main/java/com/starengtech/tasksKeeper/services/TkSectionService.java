package com.starengtech.tasksKeeper.services;

import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.repositories.TkSectionRepository;
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
public class TkSectionService {

    @Autowired
    private TkSectionRepository repository;

    public List<TkSection> findAll() {
        return repository.findAll();
    }

    public Optional<TkSection>  findById(Long id) {
        try{
            return repository.findById(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Optional<TkSection> findByTitle(String title) {
        try{
            return repository.findByTitle(title);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public TkSection insert(TkSection section) {
        section.setInsertTime(Instant.now());
        return repository.save(section);
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

    public TkSection update(Long id, TkSection section) {
        try {
            TkSection entity = repository.getById(id);
            entity.setTitle(section.getTitle());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
