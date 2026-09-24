package com.example.scoreapi.controller;

import com.example.scoreapi.dto.ErrorResponse;
import com.example.scoreapi.dto.ScoreResponse;
import com.example.scoreapi.model.StudentScore;
import com.example.scoreapi.service.ScoreService;
import com.example.scoreapi.service.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
public class ScoreRestController {

    private final ScoreService scoreService;
    private final TokenService tokenService;

    public ScoreRestController(
            ScoreService scoreService,
            TokenService tokenService) {

        this.scoreService = scoreService;
        this.tokenService = tokenService;
    }

    @GetMapping("/{sbd}")
    public ResponseEntity<?> getScore(

            @PathVariable String sbd,

            @RequestHeader("User-Token")
            String userToken) {

        // Bước 1: kiểm tra token
        if (!tokenService.isValidToken(userToken)) {

            return ResponseEntity
                    .status(401)
                    .body(
                        new ErrorResponse(
                            "User-Token không hợp lệ"
                        )
                    );
        }

        // Bước 2: tìm học sinh
        Optional<StudentScore> result =
                scoreService.findBySbd(sbd);

        // Bước 3: không tìm thấy
        if (result.isEmpty()) {

            return ResponseEntity
                    .status(404)
                    .body(
                        new ErrorResponse(
                            "Không tìm thấy SBD"
                        )
                    );
        }

        StudentScore score = result.get();

        // Bước 4: trả JSON
        ScoreResponse response =
                new ScoreResponse(
                        score.getSbd(),
                        score.getHoTen(),
                        score.getToan(),
                        score.getVan(),
                        score.getAnh()
                );

        return ResponseEntity.ok(response);
    }
}