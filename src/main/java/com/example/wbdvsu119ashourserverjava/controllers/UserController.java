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

import com.example.wbdvsu119ashourserverjava.models.User;

@RestController
public class UserController {
	private User[] users = {
            new User(1, "alice", "alice", "Alice", "Wonderland"),
            new User(2, "bob", "bob", "Bob", "The builder"),
            new User(3, "charlier", "charlier", "Charlier", "Brown")
    };
    List<User> userArrayList = new ArrayList<User>(Arrays.asList(users));
	
	@GetMapping("/users")
	public List<User> findAllUser() {
		return userArrayList;
	}
	
	@DeleteMapping("/users/{userId}")
    public List<User> deleteUser(@PathVariable("userId") long userId) {
        User u = null;
        for(User user:userArrayList) {
            if(user.getId() == userId) {
                u = user;
            }
        }
        userArrayList.remove(u);
        return userArrayList;
    }
	
	@PostMapping("/users")
	public List<User> createUser(@RequestBody User user) {
		userArrayList.add(user);
		return userArrayList;
	}

	 @PutMapping("/users/{userId}") 
	 public List<User> updateUser(@PathVariable("userId") long userId, @RequestBody User user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String username = user.getUsername();
		String role = user.getRole();
		
		for(User u:userArrayList) {
			if(u.getId() == userId) {
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setUsername(username);
				u.setRole(role);
			}
		}
		
		return userArrayList;
		 
	 }
	
 
}
