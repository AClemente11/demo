package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note{

    private @Id @GeneratedValue Long id;
    private String titolo;
    private String descrizione;

    Note(){}

    Note(String title, String description) {
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