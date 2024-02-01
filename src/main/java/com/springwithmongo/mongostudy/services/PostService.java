package com.springwithmongo.mongostudy.services;

import com.springwithmongo.mongostudy.domain.Post;
import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.dto.UserDTO;
import com.springwithmongo.mongostudy.repository.PostRepository;
import com.springwithmongo.mongostudy.repository.UserRepository;
import com.springwithmongo.mongostudy.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Document not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
