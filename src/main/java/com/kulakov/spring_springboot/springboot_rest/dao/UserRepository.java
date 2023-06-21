package com.kulakov.spring_springboot.springboot_rest.dao;

import com.kulakov.spring_springboot.springboot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


}
