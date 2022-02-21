package com.example.demo;

public class TodoResponse {
    public String titolo;
    public String descrizione;

    TodoResponse(){

    }
    //TodoResponse fromTodo(neo4jNote nota){
     //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    TodoResponse(Todo nota){

        this.titolo = nota.getTitolo();
        this.descrizione = nota.getDescrizione();
    }
    public static Note fromResponseSql(TodoResponse response){
        return new Note(response.titolo, response.descrizione);
    }
    public static Neo4jNote fromResponse4j(TodoResponse response){
        return new Neo4jNote(response.titolo, response.descrizione);
    }
}
