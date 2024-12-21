package com.example.task315.util;

import com.example.task315.entities.Role;
import com.example.task315.entities.User;
import com.example.task315.repositories.RoleRepository;
import com.example.task315.repositories.UserRepository;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
@Component
public class Creat {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    Creat(UserRepository userRepository,RoleRepository roleRepository){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;

    }
    @PostConstruct
    public void run(){
        Role role = new Role(1,"ADMIN");
        Role role1 = new Role(2,"USER");
        roleRepository.save(role);
        roleRepository.save(role1);
        Set<Role>SetRoles=new HashSet<>();
        SetRoles.add(role);
        SetRoles.add(role1);
        Set<Role>users=new HashSet<>();
        users.add(role1);
        User user = new User("ADMIN@mail.com","SERGEY", "SEMCHISHIN",25,SetRoles, "$2a$12$ujbObn1GXyGhB6cwWcNyKuB/McxcFthng7PDs9PsrbJ8NWqeXeE9e");
        User user1 = new User("USER@mail.com","USER", "USER",25,users, "$2a$12$ujbObn1GXyGhB6cwWcNyKuB/McxcFthng7PDs9PsrbJ8NWqeXeE9e");
        userRepository.save(user);
        userRepository.save(user1);
    }

}


