package com.example.demo;

import org.springframework.stereotype.Service;
@Service
public interface UserService<T> {

        Iterable<T> getUser();

        T getUsers(Long id);

        T PutUser(Long id, UserResponse newUser);

        void deleteUser(Long id);

        T createUser(UserResponse newUser);
        Iterable<T> getNotes(Long id);

}
