package com.example.webdb.Controller;

import com.example.webdb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.webdb.Entity.User;

import java.util.List;

@RestController
@CrossOrigin
public class CRUDController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        return userRepository.getUser(id);
    }
    @GetMapping("/user")
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userRepository.saveUser(user);
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userRepository.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteUser(id);
    }
}
