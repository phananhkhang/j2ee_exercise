package com.example.scoreapi.service;

import com.example.scoreapi.repository.ApiUserRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final ApiUserRepository apiUserRepository;

    public TokenService(ApiUserRepository apiUserRepository) {
        this.apiUserRepository = apiUserRepository;
    }

    public boolean isValidToken(String token) {

        return apiUserRepository
                .findByUserTokenAndActiveTrue(token)
                .isPresent();
    }
}