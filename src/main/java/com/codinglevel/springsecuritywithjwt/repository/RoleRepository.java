package com.codinglevel.springsecuritywithjwt.repository;

import com.codinglevel.springsecuritywithjwt.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
