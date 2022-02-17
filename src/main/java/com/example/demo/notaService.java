package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notaService {
    
    @Autowired
    private noteRepository noterepository;

    Iterable<Note> getNotes(){
        return noterepository.findAll();
    }
    Note getNotes(Long id){
        return noterepository.findById(id).orElseThrow();
    }
    Note PutNote( Long id, Note nuovanota){
        Note nota = noterepository.findById(id).orElseThrow();
        nota.setTitolo(nuovanota.getTitolo());
        nota.setDescrizione(nuovanota.getDescrizione());
        return noterepository.save(nota);
    }
    void deleteNote( Long id){
        noterepository.deleteById(id);
    }
    Note createNote(Note newNote){
        return noterepository.save(newNote);

    }
}
