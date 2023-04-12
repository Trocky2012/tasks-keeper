package com.starengtech.tasksKeeper.resources;

import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entitiesDTO.TkSectionDTO;
import com.starengtech.tasksKeeper.services.TkSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tksection")
public class TkSectionResource {
    
    @Autowired
    private TkSectionService service;

    @GetMapping
    public ResponseEntity<List<TkSectionDTO>> findAll(){
        List<TkSection> list = service.findAll();
        List<TkSectionDTO> listDto = list.stream().map(x -> new TkSectionDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TkSectionDTO> findById(@PathVariable Long id){
        Optional<TkSection> profile;
        profile = service.findById(id);
        if(!profile.isEmpty()){
            TkSectionDTO userDto = new TkSectionDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/find-by-title")
    public ResponseEntity <TkSectionDTO> findByTitle(@RequestParam(name = "title") String title) {
        Optional<TkSection> profile;
        profile = service.findByTitle(title);

        if(!profile.isEmpty()){
            TkSectionDTO userDto = new TkSectionDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<TkSectionDTO> insert(@RequestBody TkSection Profile){
        TkSectionDTO ProfileDTO = new TkSectionDTO(service.insert(Profile));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
