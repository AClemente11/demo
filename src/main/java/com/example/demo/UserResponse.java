package com.example.demo;

public class UserResponse {
    public String nome;

    UserResponse(){

    }
    //TodoResponse fromTodo(neo4jNote nota){
    //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    UserResponse(Utenti user){
        this.nome = user.getNome();
    }
    public static Note fromResponseSql(TodoResponse response){
        return new Note(response.titolo, response.descrizione);
    }
    public static Utente4j fromResponse4j(UserResponse response){
        return new Utente4j(response.nome);
    }
}
