package com.example.demo;

public class TodoResponse {
    public String titolo;
    public String descrizione;
    

    //TodoResponse fromTodo(neo4jNote nota){
     //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    TodoResponse(Todo nota){

        this.titolo = nota.getTitolo();
        this.descrizione = nota.getDescrizione();
    }
    
}
