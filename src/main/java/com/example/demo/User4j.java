package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "User4j")
public class User4j implements Users {
    @Id @GeneratedValue
    private Long id;

    private String userName;
    @Relationship(value = "WRITES",type = "WRITES")
    private List<Neo4jNote> notes;
    public List<Neo4jNote> getNotes() { return notes; }

    User4j(){}
    public User4j(String name) {
        super();
        this.userName = name;
    }


    @Override
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name){
        this.userName = name;
    }

}
