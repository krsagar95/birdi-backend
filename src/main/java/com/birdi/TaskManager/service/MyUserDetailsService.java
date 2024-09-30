package com.birdi.TaskManager.service;

 

import java.util.ArrayList;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

 

import com.birdi.TaskManager.model.User;

import com.birdi.TaskManager.repository.UserRepository;

 

@Service

public class MyUserDetailsService implements UserDetailsService {

    @Autowired

    private UserRepository userRepository;

 

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)

                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }

 

    // Method to fetch user info by username

    public User getUserInfoByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)

                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

 

    // Method to save a new user

    public void saveUser(User user) {

        userRepository.save(user);

    }

}