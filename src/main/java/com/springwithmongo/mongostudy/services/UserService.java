package com.springwithmongo.mongostudy.services;

import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
}
