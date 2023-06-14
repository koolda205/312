package com.kulakov.spring_springboot.springboot_rest.dao;

import com.kulakov.spring_springboot.springboot_rest.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserByID(Long id);

    void editUser(User user);

    void deleteUserByID(Long id);


}
