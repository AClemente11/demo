package com.example.demo.sql;

import com.example.demo.Todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note implements Todo {

    private @Id @GeneratedValue Long id;
    private String titolo;
    private String descrizione;

    Note(){}

    public Note(String title, String description) {
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