package com.TransTech.LalResidency.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TransTech.LalResidency.entity.User;
import com.TransTech.LalResidency.repository.UserRepository;
import com.TransTech.LalResidency.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void registerUser(User user) {
//        // Encode and store the user's password securely
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//    @Override
//    public User loginUser(String username, String password) {
//        User user = userRepository.findByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // Successfully logged in
//            return user;
//        }
//        return null; // Authentication failed
//    }
//
//    @Override
//    public void logoutUser() {
//        // Implement logout logic (e.g., clear session)
//    }
//}
