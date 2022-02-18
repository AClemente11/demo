package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value="database.type", havingValue = "neo4j")
public class neo4jService implements notaService<neo4jNote> {
    

    @Autowired
    private TodoNeo4jRepository neo4jrepository;

    public List<neo4jNote> getNotes(){
        return neo4jrepository.trova();
    }
    public neo4jNote getNotes(Long id){
        return neo4jrepository.findById(id).orElseThrow();
    }
    public neo4jNote PutNote( Long id, neo4jNote nuovanota){
        neo4jNote nota = neo4jrepository.findById(id).orElseThrow();
        nota.setTitolo(nuovanota.getTitolo());
        nota.setDescrizione(nuovanota.getDescrizione());
        return neo4jrepository.save(nota);
    }
    public void deleteNote( Long id){
        neo4jrepository.deleteById(id);
    }
    public neo4jNote createNote(neo4jNote newNote){
        return neo4jrepository.save(newNote);
    }
}
