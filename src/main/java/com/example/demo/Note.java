package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note implements Todo{

    private @Id @GeneratedValue Long id;
    private String title;
    private String description;

    Note(){}

    Note(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;

    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}