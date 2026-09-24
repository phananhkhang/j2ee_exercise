package com.example.scoreapi.config;

import com.example.scoreapi.model.ApiUser;
import com.example.scoreapi.model.StudentScore;
import com.example.scoreapi.repository.ApiUserRepository;
import com.example.scoreapi.repository.StudentScoreRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            StudentScoreRepository studentScoreRepository,
            ApiUserRepository apiUserRepository) {

        return args -> {

            // ===============================
            // Tạo token để test API
            // ===============================
            ApiUser user = new ApiUser();

            user.setUsername("mobile-app");
            user.setUserToken("abc123");
            user.setActive(true);

            apiUserRepository.save(user);

            // ===============================
            // Tạo học sinh để test
            // ===============================
            StudentScore student = new StudentScore();

            student.setSbd("120001");
            student.setHoTen("Nguyen Van A");
            student.setToan(8.5);
            student.setVan(7.0);
            student.setAnh(9.0);

            studentScoreRepository.save(student);

            System.out.println("===== DATA TEST DA DUOC TAO =====");
            System.out.println("Token: abc123");
            System.out.println("SBD: 120001");
        };
    }
}