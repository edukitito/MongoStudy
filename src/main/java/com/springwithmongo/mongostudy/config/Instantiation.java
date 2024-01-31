package com.springwithmongo.mongostudy.config;

import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception{
        userRepository.deleteAll();

        User bob = new User(null, "Bob Brown", "bob@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User maria = new User(null, "Maria White", "maria@gmail.com");

        userRepository.saveAll(Arrays.asList(bob,maria,alex));
    }
}
