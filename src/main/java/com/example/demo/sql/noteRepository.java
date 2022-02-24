package com.example.demo.sql;

import com.example.demo.sql.Note;
import org.springframework.data.repository.CrudRepository;

public interface noteRepository extends CrudRepository<Note,Long> {
    
}
