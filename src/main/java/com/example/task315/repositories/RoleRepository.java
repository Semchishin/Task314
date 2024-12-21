package com.example.task315.repositories;


import com.example.task315.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByRole(String role);
}
