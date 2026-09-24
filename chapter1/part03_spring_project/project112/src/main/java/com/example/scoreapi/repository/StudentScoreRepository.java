package com.example.scoreapi.repository;

import com.example.scoreapi.model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentScoreRepository
        extends JpaRepository<StudentScore, Long> {

    Optional<StudentScore> findBySbd(String sbd);
}