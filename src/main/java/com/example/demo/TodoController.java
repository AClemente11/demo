package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;


    @GetMapping("/todos")
    Iterable<Todo> getNotes(){
        return (Iterable<Todo>) service.getNotes();
    }

    @GetMapping("/todos/{id}")
    Object getNotes(@PathVariable Long id){
        return service.getNotes(id);
    }
    @PutMapping("/todos/{id}")
    Object PutNote(@PathVariable Long id, @RequestBody TodoResponse response){
        return service.PutNote(id, response);
    }
    @DeleteMapping("/todos/{id}")
    void deleteNote(@PathVariable Long id){
        service.deleteNote(id);
    }
    @PostMapping("/todos")

    Object createNote(@RequestBody TodoResponse newNote){
        return  service.createNote(newNote);

    }
}
