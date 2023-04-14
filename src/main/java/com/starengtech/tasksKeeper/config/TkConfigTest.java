package com.starengtech.tasksKeeper.config;

import com.starengtech.tasksKeeper.entities.TkNote;
import com.starengtech.tasksKeeper.entities.TkSection;
import com.starengtech.tasksKeeper.entities.TkUser;
import com.starengtech.tasksKeeper.repositories.TkNoteRepository;
import com.starengtech.tasksKeeper.repositories.TkSectionRepository;
import com.starengtech.tasksKeeper.repositories.TkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TkConfigTest implements CommandLineRunner {

    @Autowired
    private TkUserRepository userRepository;

    @Autowired
    private TkSectionRepository sectionRepository;

    @Autowired
    private TkNoteRepository noteRepository;

    @Override
    public void run(String... args) throws Exception {

        TkUser u1 = new TkUser(null, "Thiago","Trolle", "thiago@gmail.com", "*963");
        TkUser u2 = new TkUser(null, "Aline","Scheffer", "aline@gmail.com", "*987");

        userRepository.saveAll(Arrays.asList(u1, u2));

        TkSection s1 = new TkSection(null, "Title 1 for Thiago", u1);
        TkSection s2 = new TkSection(null, "Title 1 for Aline", u2);

        sectionRepository.saveAll(Arrays.asList(s1,s2));

        TkNote n1 = new TkNote(null, u1.getId(), "2023-04-14", "Task Thiago/Note 1 - Section 1", s1);
        TkNote n2 = new TkNote(null, u2.getId(), "2023-04-20", "Task Aline/Note 2 - Section 2", s2);
        TkNote n3 = new TkNote(null, u2.getId(), "2023-10-04", "Task Aline/Note 3 - Section 2","My comment", s2);
        TkNote n4 = new TkNote(null, u2.getId(), "2023-03-10", "Task Aline/Note 4 - Section 2", s2);

        noteRepository.saveAll(Arrays.asList(n1,n2,n3,n4));
    }
}
