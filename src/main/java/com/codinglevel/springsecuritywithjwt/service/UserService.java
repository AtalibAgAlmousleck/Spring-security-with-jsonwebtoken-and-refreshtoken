package com.codinglevel.springsecuritywithjwt.service;

import com.codinglevel.springsecuritywithjwt.entities.Role;
import com.codinglevel.springsecuritywithjwt.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
