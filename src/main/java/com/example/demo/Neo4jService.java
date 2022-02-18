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
        return todoRepository.trova();
    }
    public Neo4jNote getNotes(Long id){
        return todoRepository.findById(id).orElseThrow();
    }

    public Neo4jNote PutNote( Long id, Neo4jNote nuovanota){
        Neo4jNote nota = todoRepository.findById(id).orElseThrow();
        nota.setTitolo(nuovanota.getTitolo());
        nota.setDescrizione(nuovanota.getDescrizione());
        return todoRepository.save(nota);
    }
    public void deleteNote( Long id){
        todoRepository.deleteById(id);
    }
    public Neo4jNote createNote(Neo4jNote newNote){
        return todoRepository.save(newNote);
    }
}
