package com.example.demo.neo4j;

import java.util.List;

import com.example.demo.neo4j.Neo4jNote;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

public interface TodoNeo4jRepository extends Neo4jRepository<Neo4jNote, Long> {

    @Query("MATCH (u:neo4jNote) RETURN u")
    List<Neo4jNote> trova();
}
