package com.example.demo;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = "neo4jNote")
public class neo4jNote implements Todo{
    private @Id @GeneratedValue Long id;
    private String titolo;
    private String descrizione;

    neo4jNote(){}

    neo4jNote(String title, String description) {
        super();
        titolo = title;
        descrizione = description;
    }
    public String getTitolo(){
        return titolo;
    }
    public void setTitolo(String titolo){
        this.titolo = titolo;

    }
    public void setDescrizione(String descrizione){
        this.descrizione = descrizione;
    }
    public String getDescrizione(){
        return descrizione;
    }
}
