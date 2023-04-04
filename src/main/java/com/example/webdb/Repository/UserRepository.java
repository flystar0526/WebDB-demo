package com.example.webdb.Repository;

import com.example.webdb.Entity.User;

import java.util.List;

public interface UserRepository {
    User getUser(int id);
    User saveUser(User user);
    User updateUser(User user);
    String deleteUser(int id);
    List<User> findAll();
}
