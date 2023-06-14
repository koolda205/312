package com.kulakov.spring_springboot.springboot_rest.controller;

import com.kulakov.spring_springboot.springboot_rest.model.User;
import com.kulakov.spring_springboot.springboot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "all-users";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/findUsersById")
    public String findUsersById(@RequestParam(value = "id", required = false) Long id,
                                Model model) {

        model.addAttribute("user", userService.getUserByID(id));

        return "user-info";
    }

    @RequestMapping("/editUserById")
    public String editUsersById(@RequestParam(value = "id", required = false) Long id, Model model) {

        model.addAttribute("user", userService.getUserByID(id));


        return "edit";
    }

    @RequestMapping("/editUser")
    public String edit(@ModelAttribute("user") User user) {

        userService.editUser(user);

        return "redirect:/";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUser(@RequestParam(value = "id", required = false) Long id) {

        userService.deleteUserByID(id);

        return "redirect:/";
    }


}