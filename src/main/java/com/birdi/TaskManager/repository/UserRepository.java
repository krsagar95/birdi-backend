package com.birdi.TaskManager.repository;

 

import java.util.Optional;

 

import org.springframework.data.jpa.repository.JpaRepository;

 

import com.birdi.TaskManager.model.User;

 

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}