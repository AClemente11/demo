package com.example.demo.sql;

import com.example.demo.Todo;
import com.example.demo.Utenti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UtenteSQL implements Utenti {

    private @Id @GeneratedValue Long id;
    private String nome;

    UtenteSQL(){}

    public UtenteSQL(String nome) {
        super();
        this.nome = nome;

    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;

    }
}