package com.sgu.j2ee.chapter1.project110.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class CaptchaController {
    @GetMapping("/captcha")
    public String showCaptcha(Model model) {
        int number = ThreadLocalRandom.current().nextInt(1, 21);
        String imageName = "captcha" + number + ".png";
        model.addAttribute("imageName", imageName);
        return "captcha";
    }
}
