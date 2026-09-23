package com.sgu.j2ee.chapter1.project114.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.sgu.j2ee.chapter1.project114.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final List<Feedback> feedbackList = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong idGenerator = new AtomicLong(1);

    public FeedbackService() {
        // Initial sample feedbacks
        saveFeedback(new Feedback(
                idGenerator.getAndIncrement(),
                "Nguyễn Văn An",
                "an.nguyen@example.com",
                "0901234567",
                "Dịch vụ kỹ thuật",
                5, 5, 5,
                "Nhân viên hỗ trợ rất nhiệt tình, giải quyết sự cố trong vòng 15 phút. Rất hài lòng!",
                true
        ));
        saveFeedback(new Feedback(
                idGenerator.getAndIncrement(),
                "Trần Thị Mai",
                "mai.tran@example.com",
                "0918765432",
                "Giao hàng & Vận chuyển",
                4, 5, 4,
                "Đóng gói cẩn thận, hàng nguyên vẹn, tài xế thân thiện và lịch sự.",
                true
        ));
        saveFeedback(new Feedback(
                idGenerator.getAndIncrement(),
                "Lê Hoàng Long",
                "long.le@example.com",
                "0987654321",
                "Chăm sóc khách hàng",
                5, 5, 4,
                "Tổng đài tư vấn rõ ràng, hướng dẫn chi tiết các tính năng mới.",
                true
        ));
    }

    public List<Feedback> getAllFeedbacks() {
        return new ArrayList<>(feedbackList);
    }

    public Feedback saveFeedback(Feedback feedback) {
        if (feedback.getId() == null) {
            feedback.setId(idGenerator.getAndIncrement());
        }
        feedbackList.add(0, feedback); // Add newest first
        return feedback;
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public double getAverageRating() {
        if (feedbackList.isEmpty()) {
            return 5.0;
        }
        double sum = feedbackList.stream().mapToInt(Feedback::getOverallRating).sum();
        return Math.round((sum / feedbackList.size()) * 10.0) / 10.0;
    }

    public long getTotalCount() {
        return feedbackList.size();
    }

    public int getRecommendPercentage() {
        if (feedbackList.isEmpty()) {
            return 100;
        }
        long recommendedCount = feedbackList.stream().filter(f -> Boolean.TRUE.equals(f.getRecommend())).count();
        return (int) Math.round(((double) recommendedCount / feedbackList.size()) * 100);
    }
}
