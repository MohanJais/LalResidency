package com.TransTech.LalResidency.service;

import com.TransTech.LalResidency.entity.User;

public interface UserService {
    void registerUser(User user);
    User loginUser(String username, String password);
    void logoutUser();
}
