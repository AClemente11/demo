package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "Utente4j")
public class Utente4j implements Utenti{
    @Id @GeneratedValue
    private Long id;
    private String nome;
    @Relationship(value = "WRITES",type = "WRITES")
    private List<Neo4jNote> notes;
    public List<Neo4jNote> getNotes() { return notes; }

    Utente4j(){}
    public Utente4j(String nome) {
        super();
        this.nome = nome;
    }


    @Override
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;

    }

}
