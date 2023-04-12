package com.starengtech.tasksKeeper.services;

import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.repositories.TkUserRepository;
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
public class ProfileService {

    @Autowired
    private TkUserRepository repository;

    public List<TkUser> findAll() {
        return repository.findAll();
    }

    public TkUser findById(Long id) {
        Optional<TkUser> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    public Optional<TkUser> findByEmail(String email) {
        try{
            return repository.findByEmail(email);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Optional<TkUser> findByEmailAndPassword(String email, String password) {
        try{
            String decodedPssd = password.replace("kw*s.x$37tth@$u0K8lE9","").replace("0K2.lp$fzE6qj*tk5lp@$","").trim();
            return repository.findByEmailAndPassword(email,decodedPssd);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public TkUser insert(TkUser profile) {
        profile.setLastLoginTime(Instant.now());
        return repository.save(profile);
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

    public TkUser update(Long id, TkUser profile) {
        try {
            TkUser entity = repository.getById(id);
            entity.setName(profile.getName());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
