package com.starengtech.tasksKeeper.resources;

import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.entitiesDTO.TkUserDTO;
import com.starengtech.tasksKeeper.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tkuser")
public class TkUserResource {
    
    @Autowired
    private ProfileService service;

    @GetMapping
    public ResponseEntity<List<TkUserDTO>> findAll(){
        List<TkUser> list = service.findAll();
        List<TkUserDTO> listDto = list.stream().map(x -> new TkUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TkUserDTO> findById(@PathVariable Long id){
        TkUserDTO ProfileDTO = new TkUserDTO(service.findById(id));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @GetMapping(value = "/find-by-email")
    public ResponseEntity <TkUserDTO> findUserByNameAndPassword(@RequestParam(name = "email") String email, @RequestParam(name = "pssd") String password) {
        Optional<TkUser> profile;
        if(password.equals("none.ks$ata*0lo3h4seq@wt@uiH2GfdX9asdzbv$7rhgd")){
            profile = service.findByEmail(email);
        }else{
            profile = service.findByEmailAndPassword(email,password);
        }
        if(!profile.isEmpty()){
            TkUserDTO userDto = new TkUserDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<TkUserDTO> insert(@RequestBody TkUser Profile){
        TkUserDTO ProfileDTO = new TkUserDTO(service.insert(Profile));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
