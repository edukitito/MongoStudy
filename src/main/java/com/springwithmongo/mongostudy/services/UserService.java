package com.springwithmongo.mongostudy.services;

import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.repository.UserRepository;
import com.springwithmongo.mongostudy.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Document not found"));
    }
}
