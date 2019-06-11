package com.example.wbdvsu119ashourserverjava.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu119ashourserverjava.repositories.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.wbdvsu119ashourserverjava.models.User;

@RestController
public class UserController {
    private User[] users = {
            new User(1, "alice", "alice", "Alice", "Wonderland"),
            new User(2, "bob", "bob", "Bob", "The builder"),
            new User(3, "charlier", "charlier", "Charlier", "Brown")
    };
    List<User> userArrayList = new ArrayList<User>(Arrays.asList(users));

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return (List<User>)repository.findAll();
//        return userArrayList;
    }

    @GetMapping("/users/username/{username}")
    public User findUserByUsername(@PathVariable("username") String username) {
        return repository.findUserByUsername(username);
    }

    @GetMapping("/users/username/{username}/password/{password}")
    public User findUserByCredentials(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {
        return repository.findUserByCredentials(username, password);
    }

//     @GetMapping("/users/{userId}")
//     public User findUserById(@PathVariable("userId") Long userId) {
//         Optional<User> optional = repository.findById(userId);
//         return optional.get();
//     }

//     @DeleteMapping("/users/{userId}")
//     public List<User> deleteUser(
//             @PathVariable("userId") Long userId) {
//         repository.deleteById(userId);
//         return findAllUsers();
//     }

//     @PutMapping("/users/{userId}")
//     public List<User> updateUser(
//             @PathVariable("userId") Long userId,
//             @RequestBody User userUpdates) {
//         Optional<User> optional = repository.findById(userId);
//         User user = optional.get();
//         user.setPassword(userUpdates.getPassword());
//         repository.save(user);
//         return findAllUsers();
//     }
    
//     @PostMapping("/users")
//     public List<User> createUser(@RequestBody User user) {
//         repository.save(user);
// //        userArrayList.add(user);
//         return findAllUsers();
//     }
    
}