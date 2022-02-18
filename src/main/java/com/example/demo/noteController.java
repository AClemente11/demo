package com.example.demo;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class noteController {
    @Autowired
    private notaService notaservice;

    //@GetMapping("/todos")
    //Iterable<TodoResponse> getNotes(){
      //  Iterable<Todo> lista =  notaservice.getNotes();
        //Iterable<TodoResponse> result = (Iterable<TodoResponse>) StreamSupport.stream(lista.spliterator(),false).map(s -> new TodoResponse(s));
        //return result;
    //}
    @GetMapping("/todos")
    Iterable<Todo> getNotes(){
        Iterable<Todo> lista =  notaservice.getNotes();
        return lista;
    }
    @GetMapping("/todos/{id}")
    Object getNotes(@PathVariable Long id){
        return notaservice.getNotes(id);
    }
    @PutMapping("/todos/{id}")
    Object PutNote(@PathVariable Long id, @RequestBody Note nuovanota){
        return notaservice.PutNote(id, nuovanota);
    }
    @DeleteMapping("/todos/{id}")
    void deleteNote(@PathVariable Long id){
        notaservice.deleteNote(id);
    }
    @PostMapping("/todos")
    Object createNote(@RequestBody Note newNote){
        return  notaservice.createNote(newNote);

    }
}
