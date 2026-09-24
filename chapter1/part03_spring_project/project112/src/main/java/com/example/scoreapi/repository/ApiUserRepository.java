package com.example.scoreapi.repository;

import com.example.scoreapi.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepository
        extends JpaRepository<ApiUser, Long> {

    Optional<ApiUser> findByUserTokenAndActiveTrue(String userToken);
}