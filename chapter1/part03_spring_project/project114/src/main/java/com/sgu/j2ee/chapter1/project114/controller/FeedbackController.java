package com.sgu.j2ee.chapter1.project114.controller;

import java.util.Arrays;
import java.util.List;

import com.sgu.j2ee.chapter1.project114.model.Feedback;
import com.sgu.j2ee.chapter1.project114.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    private static final List<String> SERVICE_TYPES = Arrays.asList(
            "Dịch vụ kỹ thuật & IT",
            "Giao hàng & Vận chuyển",
            "Chăm sóc khách hàng",
            "Dịch vụ bảo hành & Sửa chữa",
            "Trải nghiệm sản phẩm & Mua sắm"
    );

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping(value = { "/", "/feedback" })
    public String showFeedbackForm(Model model) {
        if (!model.containsAttribute("feedback")) {
            model.addAttribute("feedback", new Feedback());
        }
        model.addAttribute("serviceTypes", SERVICE_TYPES);
        return "feedback-form";
    }

    @PostMapping("/feedback")
    public String handleFeedbackSubmission(@ModelAttribute("feedback") Feedback feedback, Model model) {
        // Simple validation
        if (feedback.getFullName() == null || feedback.getFullName().trim().isEmpty()
                || feedback.getEmail() == null || feedback.getEmail().trim().isEmpty()
                || feedback.getServiceType() == null || feedback.getServiceType().trim().isEmpty()) {
            model.addAttribute("errorMessage", "Vui lòng điền đầy đủ Họ tên, Email và chọn Loại dịch vụ!");
            model.addAttribute("serviceTypes", SERVICE_TYPES);
            return "feedback-form";
        }

        Feedback saved = feedbackService.saveFeedback(feedback);
        return "redirect:/feedback/success?id=" + saved.getId();
    }

    @GetMapping("/feedback/success")
    public String showSuccessPage(@RequestParam("id") Long id, Model model) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback == null) {
            return "redirect:/feedback";
        }
        model.addAttribute("feedback", feedback);
        return "feedback-success";
    }

    @GetMapping("/feedbacks")
    public String showAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        model.addAttribute("averageRating", feedbackService.getAverageRating());
        model.addAttribute("totalCount", feedbackService.getTotalCount());
        model.addAttribute("recommendPercentage", feedbackService.getRecommendPercentage());
        return "feedback-list";
    }
}
