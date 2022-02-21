package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "mysql")
public class mySQLService implements TodoService<Note> {

    @Autowired
    private noteRepository noterepository;


    public Iterable<Note> getNotes(){
        return noterepository.findAll();
    }

    public Note getNotes(Long id){

        return noterepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
    public Note PutNote( Long id, TodoResponse nuovanota){
        Note nota = noterepository.findById(id).orElseThrow(() -> new RuntimeException());
        Note newnote = TodoResponse.fromResponseSql(nuovanota);
        nota.setTitolo(newnote.getTitolo());
        nota.setDescrizione(newnote.getDescrizione());
        return noterepository.save(nota);
    }
    public void deleteNote( Long id){
        noterepository.deleteById(id);
    }
    public Note createNote(TodoResponse response){
        return noterepository.save(TodoResponse.fromResponseSql(response));

    }
}
