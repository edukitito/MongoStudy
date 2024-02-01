package com.springwithmongo.mongostudy.config;

import com.springwithmongo.mongostudy.domain.Post;
import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.dto.AuthorDTO;
import com.springwithmongo.mongostudy.repository.PostRepository;
import com.springwithmongo.mongostudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("Brazil"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User bob = new User(null, "Bob Brown", "bob@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User maria = new User(null, "Maria White", "maria@gmail.com");

        userRepository.saveAll(Arrays.asList(bob,maria,alex));

        Post post1 = new Post(null, sdf.parse("21/03/2021"), "Partiu Viagem", "Vou viajar para Cuiabá", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("27/03/2021"), "Boa noite", "Apreciar um vinho em uma noite gelada, não tem nada de melhor", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
