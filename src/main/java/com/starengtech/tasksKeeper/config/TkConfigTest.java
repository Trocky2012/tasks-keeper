package com.starengtech.tasksKeeper.config;

import com.starengtech.tasksKeeper.entities.TkUser;
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
    private TkUserRepository profileRepository;

    @Override
    public void run(String... args) throws Exception {

        TkUser u1 = new TkUser(null, "Thiago","Trolle", "thiago@gmail.com", "123456");
        TkUser u2 = new TkUser(null, "Aline","Scheffer", "aline@gmail.com", "123456");

        profileRepository.saveAll(Arrays.asList(u1, u2));
    }
}
