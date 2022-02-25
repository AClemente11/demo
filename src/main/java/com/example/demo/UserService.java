package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService<T> {

        Iterable<T> getUser();

        T getUsers(Long id);

        T PutUser(Long id, UserResponse newUser);

        void deleteUser(Long id);

        T createUser(UserResponse newUser);
        T getNotes(Long id);
        Collection<Projection> countNotes();

}
