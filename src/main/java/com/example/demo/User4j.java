package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "Utente4j")
public class User4j implements Users {
    @Id @GeneratedValue
    private Long id;

    private String nomeUtente;
    @Relationship(value = "WRITES",type = "WRITES")
    private List<Neo4jNote> notes;
    public List<Neo4jNote> getNotes() { return notes; }

    User4j(){}
    public User4j(String nome) {
        super();
        this.nomeUtente = nome;
    }


    @Override
    public String getNomeUtente() {
        return nomeUtente;
    }
    public void setNomeUtente(String nome){
        this.nomeUtente = nome;
    }

}
