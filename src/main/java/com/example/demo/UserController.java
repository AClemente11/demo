package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController {
    @Autowired UserService userservice;

    @GetMapping("/users")
    Iterable<Users> getUsers(){
        return userservice.getUser();
    }
    @GetMapping("/user/{id}")
    Object getUser(@PathVariable Long id){
        return userservice.getUsers(id);
    }
    @PutMapping("/user/{id}")
    Object PutUser(@PathVariable Long id, @RequestBody UserResponse nuovouser){
        return userservice.PutUser(id, nuovouser);
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id){
        userservice.deleteUser(id);
    }
    @PostMapping("/user")
    Object createUser(@RequestBody UserResponse nuovouser){
        return  userservice.createUser(nuovouser);
    }
    @GetMapping("/usernote/{id}")
    Object getNotes(@PathVariable Long id){
        return userservice.getNotes(id);
    }
    @GetMapping("/user/conta")
    Collection<Object> contaNote(){
       return userservice.contaNote();
    }
}
