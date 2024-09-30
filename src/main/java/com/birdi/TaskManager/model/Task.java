package com.birdi.TaskManager.model;

 

import java.time.LocalDate;

 

import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Entity

@Data

@AllArgsConstructor

@NoArgsConstructor

public class Task {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

 

    @Column(nullable = false)

    private String title;

 

    @Lob

    @Column(columnDefinition = "TEXT")

    private String description;

 

    @Column(nullable = false)

    private LocalDate dueDate;

 

    @Enumerated(EnumType.STRING)

    private Status status;

 

    @Column(nullable = false)

    private Long userId;

}

 

enum Status {

    PENDING,

    COMPLETED,

    IN_PROGRESS

}