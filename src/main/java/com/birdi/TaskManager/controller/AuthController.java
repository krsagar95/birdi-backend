package com.birdi.TaskManager.controller;

 

import com.birdi.TaskManager.model.User;

import com.birdi.TaskManager.service.MyUserDetailsService;

import com.birdi.TaskManager.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 

import java.util.HashMap;

import java.util.Map;

 

@RestController

@RequestMapping("/api/auth")

public class AuthController {

 

    @Autowired

    private AuthenticationManager authenticationManager;

 

    @Autowired

    private MyUserDetailsService userDetailsService;

 

    @Autowired

    private JwtUtil jwtUtil;

 

    @Autowired

    private PasswordEncoder passwordEncoder;

 

    @PostMapping("/register")

    public ResponseEntity<?> register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDetailsService.saveUser(user);

        return ResponseEntity.ok("User registered successfully");

    }

 

    @PostMapping("/login")

    public ResponseEntity<?> createAuthenticationToken(@RequestBody User request) throws Exception {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        final String jwt = jwtUtil.generateToken(request.getUsername());

        final User user = userDetailsService.getUserInfoByUsername(request.getUsername());

        Map<String, Object> response = new HashMap<>();

        response.put("id", user.getId());

        response.put("username", user.getUsername());

        response.put("email", user.getEmail());

        response.put("mobileNo", user.getMobileNo());

        response.put("role", user.getRole());

        response.put("name", user.getName());

        response.put("token", jwt);

        return ResponseEntity.ok(response);

    }

}