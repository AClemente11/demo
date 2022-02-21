package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired UserService userservice;

    @GetMapping("/users")
    Iterable<Utenti> getUsers(){
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
    Iterable<Todo> getNotes(@PathVariable Long id){
        return userservice.getNotes(id);
    }
}
