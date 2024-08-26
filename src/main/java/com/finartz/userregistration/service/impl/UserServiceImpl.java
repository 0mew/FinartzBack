package com.finartz.userregistration.service.impl;

import com.finartz.userregistration.entity.User;
import com.finartz.userregistration.repository.UserRepository;
import com.finartz.userregistration.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
       return new UserDetailsService() {
        @Override
        public UserDetails loadUserByUsername(String username) {
            return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }
       };
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    } 
}
