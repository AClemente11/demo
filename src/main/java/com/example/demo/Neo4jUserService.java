package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "neo4j")
public class Neo4jUserService implements UserService<User4j> {
    @Autowired
    UserNeo4jRepository repository;

    @Override
    public Iterable<User4j> getUser() {
        return repository.findAll();
    }

    @Override
    public User4j getUsers(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public User4j PutUser(Long id, UserResponse response) {
        User4j mod_user = repository.findById(id).orElseThrow(() -> new RuntimeException());
        mod_user.setUserName(response.userName);
        return repository.save(mod_user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User4j createUser(UserResponse response) {
        return repository.save(UserResponse.fromResponse4j(response));
    }
    @Override
    public User4j getNotes(Long id){
        return repository.findByNotes(id);
    }
    public Collection<Projection> countNotes(){
       return repository.countNotes();
     }
}
