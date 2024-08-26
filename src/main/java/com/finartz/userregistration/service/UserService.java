package com.finartz.userregistration.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finartz.userregistration.entity.User;

public interface UserService {

    UserDetailsService userDetailsService();
    public List<User> getAllUsers();
}

