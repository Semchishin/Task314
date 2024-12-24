package com.example.task315.controllers;


import com.example.task315.entities.Role;
import com.example.task315.entities.User;
import com.example.task315.repositories.RoleRepository;
import com.example.task315.repositories.UserRepository;
import com.example.task315.services.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class MyRestController {
        private UserRepository userRepository;
        private RoleRepository roleRepository;

        private UserService userService;
        private final PasswordEncoder passwordEncoder;

        public MyRestController(UserRepository userRepository, RoleRepository roleRepository, UserService userService) {
            this.userRepository = userRepository;
            this.userService = userService;
            this.passwordEncoder = new BCryptPasswordEncoder();
            this.roleRepository = roleRepository;
        }

        @GetMapping("users")
        public ResponseEntity<List<User>> showAllUsers() {
            List<User> users = userRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        @GetMapping("roles/all")
        public ResponseEntity<List<Role>> getAllRoles() {
            List<Role> roles = roleRepository.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }

        @GetMapping("roles/{id}")
        public ResponseEntity<Role> getRole(@PathVariable Long id) {
            Role role = roleRepository.findById(id).get();
            return new ResponseEntity<>(role, HttpStatus.OK);
        }

        @GetMapping("users/{id}")
        public ResponseEntity<User> getUser(@PathVariable Long id) {
            User user = userRepository.findById(id).get();

            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @GetMapping("rest/user")
        public ResponseEntity<User> getUser(Principal principal) {
            return new ResponseEntity<>(userRepository.findByUsername(principal.getName()).get(), HttpStatus.OK);
        }

        @PostMapping("users")
        public ResponseEntity<User> addUser(@RequestBody User user) {
            userService.addUser(user);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }


        @PutMapping("users")
        public ResponseEntity<User> updateUser(@RequestBody User user) {
            userService.updateUser(user.getId(), user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @DeleteMapping("users/{id}")
        public ResponseEntity<User> deleteUser(@PathVariable Long id) {
            userRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
