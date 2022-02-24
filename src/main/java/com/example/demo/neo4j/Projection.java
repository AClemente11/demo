package com.example.demo.neo4j;

public class Projection {
    private String nomeUtente;
    private int numeroNote;

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String name) {
        this.nomeUtente = name;
    }

    public int getNumeroNote() {
        return numeroNote;
    }

    public void setNumeroNote(int numeroNote) {
        this.numeroNote = numeroNote;
    }
}
