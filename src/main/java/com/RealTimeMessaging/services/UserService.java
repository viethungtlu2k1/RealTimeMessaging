package com.RealTimeMessaging.services;

import com.RealTimeMessaging.entity.Role;
import com.RealTimeMessaging.entity.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
