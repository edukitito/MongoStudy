package com.springwithmongo.mongostudy.services;

import com.springwithmongo.mongostudy.domain.User;
import com.springwithmongo.mongostudy.dto.UserDTO;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> obj1 = repository.findById(obj.getId());
        User newObj = obj1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);

        return repository.save(newObj);

    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
