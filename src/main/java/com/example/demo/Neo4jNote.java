package com.example.demo;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "Neo4jNote")
public class Neo4jNote implements Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;
    //@Relationship(type = "WRITES")
    //private List<Utente4j> users;
    Neo4jNote(){}

    Neo4jNote(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;

    }

    public void setDescription(String description){

        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
