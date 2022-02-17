package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/todos")
    Iterable<Note> getNotes(){
        return notaservice.getNotes();
    }
    @GetMapping("/todos/{id}")
    Note getNotes(@PathVariable Long id){
        return notaservice.getNotes(id);
    }
    @PutMapping("/todos/{id}")
    Note PutNote(@PathVariable Long id, @RequestBody Note nuovanota){
        return notaservice.PutNote(id, nuovanota);
    }
    @DeleteMapping("/todos/{id}")
    void deleteNote(@PathVariable Long id){
        notaservice.deleteNote(id);
    }
    @PostMapping("/todos")
    Note createNote(@RequestBody Note newNote){
        return notaservice.createNote(newNote);

    }
}
