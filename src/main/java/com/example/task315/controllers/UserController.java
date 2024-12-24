
//package com.example.task315.controllers;
//
//
//
//import com.example.task315.repositories.RoleRepository;
//import com.example.task315.repositories.UserRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.security.Principal;
//
//
//@Controller
//public class UserController {
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//
//    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }
//
//    @GetMapping(value = "/user")
//    public String showUserInfo(Model model, Principal principal) {
//        model.addAttribute("currentUser", userRepository.findByUsername(principal.getName()).get());
//        return "user";
//    }
//
//
//}
