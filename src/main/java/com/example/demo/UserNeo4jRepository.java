package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserNeo4jRepository extends Neo4jRepository<User4j,Long> {

    @Query("match (n:User4j)-[w:WRITES]->(a:Neo4jNote) WHERE id(n)=$id return DISTINCT n,collect(w),collect(a)")
    User4j findByNotes(@Param("id") Long id);

    @Query("match (u:User4j)-[w:WRITES]-(n:Neo4jNote) WHERE n.title STARTS WITH 'Eccomi' return distinct(u), count(n) as noteNumber")
    Collection<Projection> countNotes();

}
