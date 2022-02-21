package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface TodoService<T> {

    Iterable<T> getNotes();

    T getNotes(Long id);

    T PutNote(Long id, TodoResponse nuovanota);

    void deleteNote(Long id);

    T createNote(TodoResponse newNote);
}
