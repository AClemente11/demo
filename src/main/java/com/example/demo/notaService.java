package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface notaService<T> {
    

    abstract Iterable<T> getNotes();
    abstract T getNotes(Long id);

    abstract T PutNote( Long id, T nuovanota);
    
    abstract void deleteNote( Long id);
    
    abstract T createNote(T newNote);
}
