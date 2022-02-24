package com.example.demo;

public class UserResponse {
    public String nomeUtente;

    UserResponse(){

    }
    //TodoResponse fromTodo(neo4jNote nota){
    //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    UserResponse(Users user){
        this.nomeUtente = user.getNomeUtente();
    }
    public static Note fromResponseSql(TodoResponse response){
        return new Note(response.titolo, response.descrizione);
    }
    public static User4j fromResponse4j(UserResponse response){
        return new User4j(response.nomeUtente);
    }
}
