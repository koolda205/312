package com.kulakov.spring_springboot.springboot_rest.dao;

import com.kulakov.spring_springboot.springboot_rest.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);
    }

    @Override
    public User getUserByID(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserByID(Long id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {

        entityManager.merge(user);
    }
}

