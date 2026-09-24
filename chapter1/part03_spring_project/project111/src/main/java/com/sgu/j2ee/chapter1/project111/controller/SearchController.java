package com.sgu.j2ee.chapter1.project111.controller;

import com.sgu.j2ee.chapter1.project111.model.CandidateScore;
import com.sgu.j2ee.chapter1.project111.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class SearchController {
    @Autowired
    private ScoreService scoreService;

    // Hiển thị trang chủ khi người dùng truy cập
    @GetMapping("/")
    public String showHomePage() {
        return "home"; // Trả về file home.html trong thư mục templates
    }

    // Xử lý khi người dùng bấm nút tra cứu
    @PostMapping("/search")
    public String searchScore(
            @RequestParam("mssv") String mssv,
            @RequestParam(value = "g-recaptcha-response", required = false) String recaptchaResponse,
            Model model) {

        // 1. Kiểm tra CAPTCHA
        boolean isHuman = scoreService.verifyRecaptcha(recaptchaResponse);
        if (!isHuman) {
            model.addAttribute("error", "Vui lòng xác nhận bạn không phải là người máy!");
            return "home";
        }

        // 2. Tra cứu điểm nếu là người thật
        Optional<CandidateScore> scoreOpt = scoreService.findScoreByMssv(mssv);
        if (scoreOpt.isPresent()) {
            model.addAttribute("score", scoreOpt.get()); // Gửi kết quả ra giao diện
        } else {
            model.addAttribute("error", "Không tìm thấy điểm cho MSSV: " + mssv);
        }

        return "home";
    }
}