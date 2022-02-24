package com.example.demo.sql;

import com.example.demo.UserResponse;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "mysql")
public class UtenteSQLService implements UserService<UtenteSQL> {

    @Autowired
    private UserSQLRepository userrepository;


    public Iterable<UtenteSQL> getUser(){
        return userrepository.findAll();
    }

    public UtenteSQL getUsers(Long id){

        return userrepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
    public UtenteSQL PutUser( Long id, UserResponse nuovouser){
        UtenteSQL user = userrepository.findById(id).orElseThrow(() -> new RuntimeException());
        UtenteSQL newuser = UserResponse.fromResponseSql(nuovouser);
        user.setNome(newuser.getNome());
        return userrepository.save(user);
    }
    public void deleteUser( Long id){
        userrepository.deleteById(id);
    }
    public UtenteSQL createUser(UserResponse response){
        return userrepository.save(UserResponse.fromResponseSql(response));

    }
    @Override
    public UtenteSQL getNotes(Long id) {
        return null;
    }

    //@Override
    //public Collection<Projection> contaNote() {
      //  return null;
    //}
}
