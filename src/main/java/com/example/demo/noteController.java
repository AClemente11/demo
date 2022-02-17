package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class noteController {
    private final noteRepository noterepository;

    noteController(noteRepository noteRepository){
        noterepository = noteRepository;
    }
    @GetMapping("/todos")
    Iterable<Note> getNotes(){
        return noterepository.findAll();
    }
    @GetMapping("/todos/{id}")
    Note getNotes(@PathVariable Long id){
        return noterepository.findById(id).orElseThrow();
    }
    @PutMapping("/todos/{id}")
    Note PutNote(@PathVariable Long id, @RequestBody Note nuovanota){
        Note nota = noterepository.findById(id).orElseThrow();
        nota.setTitolo(nuovanota.getTitolo());
        nota.setDescrizione(nuovanota.getDescrizione());
        return noterepository.save(nota);
    }
    @DeleteMapping("/todos/{id}")
    void deleteNote(@PathVariable Long id){
        noterepository.deleteById(id);
    }
    @PostMapping("/todos")
    Note createNote(@RequestBody Note newNote){
        return noterepository.save(newNote);

    }
}
