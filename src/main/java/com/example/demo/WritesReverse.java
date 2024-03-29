package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class WritesReverse {
    @Id
    @GeneratedValue
    private long id;
    @TargetNode
    private User4j start;

    public WritesReverse(long id, User4j start) {
        this.id = id;
        this.start = start;
    }

    public WritesReverse() { }

    public User4j getUser() { return start ; }
}
