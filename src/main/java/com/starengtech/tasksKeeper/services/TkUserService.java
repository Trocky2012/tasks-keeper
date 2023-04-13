package com.starengtech.tasksKeeper.services;

import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.entitiesDTO.TkUserDTO;
import com.starengtech.tasksKeeper.repositories.TkUserRepository;
import com.starengtech.tasksKeeper.services.exceptions.DatabaseException;
import com.starengtech.tasksKeeper.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TkUserService {

    @Autowired
    private TkUserRepository repository;

    public List<TkUser> findAll() {
        return repository.findAll();
    }

    public Optional<TkUser> findById(Long id) {
        try{
            return repository.findById(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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

    public TkUser insert(TkUser tkUser) {
        tkUser.setLastLoginTime(Instant.now());
        tkUser.setFlActive(true);
        return repository.save(tkUser);
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

    public TkUser update(Long id, TkUser user) {
        try {
            TkUser entity = repository.getById(id);
            entity.setfName(user.getfName());
            entity.setlName(user.getlName());
            entity.setCountry(user.getCountry());
            entity.setFlActive(user.isFlActive());
            entity.setProjectId(user.getProjectId());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //---------------

    public List<TkUser> findByProjectId(Long projectId){
        return repository.findByProjectId(projectId);
    }

    public TkUser setCountry(Long id, String country){
        try {
            TkUser entity = repository.getById(id);
            entity.setCountry(country);
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
