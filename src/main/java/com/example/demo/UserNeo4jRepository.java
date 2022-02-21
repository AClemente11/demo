package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserNeo4jRepository extends Neo4jRepository<Utente4j,Long> {

    @Query("match(n:Utente4j)-[w:WRITES]->(a:neo4jNote) WHERE id(n)=$id return n,w,a")
    Collection<Utente4j> findByNotes(@Param("id") Long id);

}
