package com.example.demo;

import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class Writes {

        @Id
        @GeneratedValue
        private long id;
        @TargetNode
        private Neo4jNote end;

        public Writes(long id, Neo4jNote end) {
            this.id = id;
            this.end = end;
        }

        public Writes() { }

    public Neo4jNote getNote() { return end ; }
}
