package com.kulakov.spring_springboot.springboot_rest.service;

import com.kulakov.spring_springboot.springboot_rest.dao.UserDao;
import com.kulakov.spring_springboot.springboot_rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser (User user) {
        userDao.saveUser (user);
    }

    @Override
    public User getUserByID(Long id) {
        return userDao.getUserByID(id);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Transactional
    @Override
    public void deleteUserByID(Long id) {
        userDao.deleteUserByID(id);
    }

}


