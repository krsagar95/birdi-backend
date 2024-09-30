package com.birdi.TaskManager.model;

 

import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Entity

@Data

@AllArgsConstructor

@NoArgsConstructor

public class User {

 

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

 

    @Column(unique = true, nullable = false)

    private String username;

 

    @Column(nullable = false)

    private String password;

 

    @Column(nullable = false)

    private String email;

   

    @Column(nullable = false)

    private String name;

 

    @Column(nullable = false)

    private String mobileNo;

 

    private String role; // e.g., "USER", "ADMIN"

}

 

