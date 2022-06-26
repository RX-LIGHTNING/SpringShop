package com.stationary.shop.services;

import com.stationary.shop.entities.User;
import com.stationary.shop.entities.enums.Role;
import com.stationary.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User registration(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return null;
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setRoles(Collections.singleton(Role.ADMIN));
        return userRepo.save(user);
    }
    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
    public void edit(User user, Role[] roles) {
        Set<Role> targetSet = new HashSet<Role>();
        Collections.addAll(targetSet, roles);
        user.setRoles(targetSet);
        userRepo.save(user);
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }
}
