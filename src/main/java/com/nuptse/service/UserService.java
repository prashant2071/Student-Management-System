package com.nuptse.service;

import com.nuptse.model.User;

import java.util.List;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public List<User> findAll();
    public User findUserById(Integer id);
}
