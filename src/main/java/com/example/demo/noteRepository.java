package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface noteRepository extends CrudRepository<Note,Long> {
    
}
