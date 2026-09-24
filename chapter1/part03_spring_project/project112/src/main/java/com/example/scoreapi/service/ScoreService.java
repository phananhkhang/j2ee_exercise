package com.example.scoreapi.service;

import com.example.scoreapi.model.StudentScore;
import com.example.scoreapi.repository.StudentScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    private final StudentScoreRepository repository;

    public ScoreService(StudentScoreRepository repository) {
        this.repository = repository;
    }

    public Optional<StudentScore> findBySbd(String sbd) {
        return repository.findBySbd(sbd);
    }
}