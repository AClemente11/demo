package com.example.demo;

public class TodoResponse {
    public String title;
    public String description;

    TodoResponse(){

    }
    //TodoResponse fromTodo(neo4jNote nota){
     //   return new TodoResponse(nota.getTitolo(), nota.getTitolo());
    //}
    TodoResponse(Todo note){

        this.title = note.getTitle();
        this.description = note.getDescription();
    }
    public static Note fromResponseSql(TodoResponse response){
        return new Note(response.title, response.description);
    }
    public static Neo4jNote fromResponse4j(TodoResponse response){
        return new Neo4jNote(response.title, response.description);
    }
}
