package com.example.demo;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface TodoNeo4jRepository extends Neo4jRepository<neo4jNote,Long> {
    @Query("MATCH (u:neo4jNote) RETURN u")
    public List<neo4jNote> trova();
    
}
