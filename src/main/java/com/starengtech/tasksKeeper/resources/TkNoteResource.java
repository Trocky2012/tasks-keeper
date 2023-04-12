package com.starengtech.tasksKeeper.resources;

import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.entitiesDTO.TkNoteDTO;
import com.starengtech.tasksKeeper.entitiesDTO.TkSectionDTO;
import com.starengtech.tasksKeeper.services.TkNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tknote")
public class TkNoteResource {
    
    @Autowired
    private TkNoteService service;

    @GetMapping
    public ResponseEntity<List<TkNoteDTO>> findAll(){
        List<TkNote> list = service.findAll();
        List<TkNoteDTO> listDto = list.stream().map(x -> new TkNoteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TkNoteDTO> findById(@PathVariable Long id){
        Optional<TkNote> section;
        section = service.findById(id);
        if(!section.isEmpty()){
            TkNoteDTO userDto = new TkNoteDTO(section.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/find-by-title")
    public ResponseEntity <TkNoteDTO> findByTitle(@RequestParam(name = "title") String title) {
        Optional<TkNote> profile;
        profile = service.findByTitle(title);

        if(!profile.isEmpty()){
            TkNoteDTO userDto = new TkNoteDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<TkNoteDTO> insert(@RequestBody TkNote Profile){
        TkNoteDTO ProfileDTO = new TkNoteDTO(service.insert(Profile));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //-------------

    @GetMapping(value = "/find-by-section")
    public ResponseEntity<List<TkNoteDTO>> findBySection (@RequestBody TkSection tkSection){
        List<TkNote> list = service.findBySection (tkSection);
        List<TkNoteDTO> listDto = list.stream().map(x -> new TkNoteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-user-id/{id}")
    public ResponseEntity<List<TkNoteDTO>> findByUserId(@PathVariable Long id){
        List<TkNote> list = service.findByUserId(id);
        List<TkNoteDTO> listDto = list.stream().map(x -> new TkNoteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
