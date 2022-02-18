package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "mysql")
public class mySQLService implements notaService<Note> {
    
    @Autowired
    private noteRepository noterepository;


    public Iterable<Note> getNotes(){
        return noterepository.findAll();
    }
    public Note getNotes(Long id){
        return noterepository.findById(id).orElseThrow();
    }
    public Note PutNote( Long id, Note nuovanota){
        Note nota = noterepository.findById(id).orElseThrow();
        nota.setTitolo(nuovanota.getTitolo());
        nota.setDescrizione(nuovanota.getDescrizione());
        return noterepository.save(nota);
    }
    public void deleteNote( Long id){
        noterepository.deleteById(id);
    }
    public Note createNote(Note newNote){
        return noterepository.save(newNote);

    }
}
