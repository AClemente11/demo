package com.example.demo;

public class UserResponse {
    public String userName;

    UserResponse(){

    }
    //TodoResponse fromTodo(neo4jNote nota){
    //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    UserResponse(Users user){
        this.userName = user.getUserName();
    }
    public static Note fromResponseSql(TodoResponse response){
        return new Note(response.title, response.description);
    }
    public static User4j fromResponse4j(UserResponse response){
        return new User4j(response.userName);
    }
}
