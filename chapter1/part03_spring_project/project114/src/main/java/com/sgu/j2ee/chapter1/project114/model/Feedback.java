package com.sgu.j2ee.chapter1.project114.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Feedback {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String serviceType;
    private Integer overallRating; // 1 to 5
    private Integer staffAttitude; // 1 to 5
    private Integer serviceSpeed;  // 1 to 5
    private String comments;
    private Boolean recommend;
    private String submittedAt;

    public Feedback() {
        this.submittedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.overallRating = 5;
        this.staffAttitude = 5;
        this.serviceSpeed = 5;
        this.recommend = true;
    }

    public Feedback(Long id, String fullName, String email, String phone, String serviceType,
                    Integer overallRating, Integer staffAttitude, Integer serviceSpeed,
                    String comments, Boolean recommend) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.serviceType = serviceType;
        this.overallRating = overallRating;
        this.staffAttitude = staffAttitude;
        this.serviceSpeed = serviceSpeed;
        this.comments = comments;
        this.recommend = recommend;
        this.submittedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getStaffAttitude() {
        return staffAttitude;
    }

    public void setStaffAttitude(Integer staffAttitude) {
        this.staffAttitude = staffAttitude;
    }

    public Integer getServiceSpeed() {
        return serviceSpeed;
    }

    public void setServiceSpeed(Integer serviceSpeed) {
        this.serviceSpeed = serviceSpeed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
    }
}
