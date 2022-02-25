package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "mysql")
public class MySQLService implements TodoService<Note> {

    @Autowired
    private NoteRepository noterepository;


    public Iterable<Note> getNotes(){
        return noterepository.findAll();
    }

    public Note getNotes(Long id){
        return noterepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
    public Note PutNote( Long id, TodoResponse response){
        Note note = noterepository.findById(id).orElseThrow(() -> new RuntimeException());
        Note newNote = TodoResponse.fromResponseSql(response);
        note.setTitle(newNote.getTitle());
        note.setDescription(newNote.getDescription());
        return noterepository.save(note);
    }
    public void deleteNote( Long id){
        noterepository.deleteById(id);
    }
    public Note createNote(TodoResponse response){
        return noterepository.save(TodoResponse.fromResponseSql(response));

    }
}
