package com.example.demo.neo4j;

import com.example.demo.UserResponse;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "neo4j")
public class Neo4jUserService implements UserService<Utente4j> {
    @Autowired
    UserNeo4jRepository repository;

    @Override
    public Iterable<Utente4j> getUser() {
        return repository.findAll();
    }

    @Override
    public Utente4j getUsers(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Utente4j PutUser(Long id, UserResponse nuovouser) {
        Utente4j mod_user = repository.findById(id).orElseThrow(() -> new RuntimeException());
        mod_user.setNome(nuovouser.nome);
        return repository.save(mod_user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Utente4j createUser(UserResponse nuovouser) {
        return repository.save(UserResponse.fromResponse4j(nuovouser));
    }
    @Override
    public Utente4j getNotes(Long id){
        return repository.findByNotes(id);
    }

    //public Collection<Projection> contaNote(){
     //   return repository.contaNote();
   // }
}
