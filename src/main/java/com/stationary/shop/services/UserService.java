package com.stationary.shop.services;

import com.stationary.shop.entities.User;
import com.stationary.shop.entities.enums.Role;
import com.stationary.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public User registration(User user){
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return null;
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setRoles(Collections.singleton(Role.USER));
        return userRepo.save(user);
    }

}
