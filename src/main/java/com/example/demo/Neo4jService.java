package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "neo4j")
public class Neo4jService implements TodoService<Neo4jNote> {

    @Autowired
    private TodoNeo4jRepository todoRepository;

    public List<Neo4jNote> getNotes(){
        return todoRepository.findAll();
    }
    public Neo4jNote getNotes(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Neo4jNote PutNote( Long id, TodoResponse response){
        Neo4jNote note = todoRepository.findById(id).orElseThrow(() -> new RuntimeException());
        Neo4jNote newNote = TodoResponse.fromResponse4j(response);
        note.setTitle(newNote.getTitle());
        note.setDescription(newNote.getDescription());
        return todoRepository.save(note);
    }
    public void deleteNote( Long id){
        todoRepository.deleteById(id);
    }
    public Neo4jNote createNote(TodoResponse response){
        return todoRepository.save(TodoResponse.fromResponse4j(response));
    }
}
