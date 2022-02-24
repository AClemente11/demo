package com.example.demo.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;
public interface UserNeo4jRepository extends Neo4jRepository<Utente4j,Long> {

    @Query("match (n:Utente4j)-[w:WRITES]->(a:neo4jNote) WHERE id(n)=$id return DISTINCT n,collect(w),collect(a)")
    Utente4j findByNotes(@Param("id") Long id);


    //@Query("match (u:Utente4j)-[w:WRITES]-(n:neo4jNote) WHERE n.titolo STARTS WITH 'Eccomi' return distinct(u), count(n)")
    //Collection<Projection> contaNote();
}
