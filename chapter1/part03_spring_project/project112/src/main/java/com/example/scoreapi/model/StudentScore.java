package com.example.scoreapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_score")
public class StudentScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sbd;

    private String hoTen;

    private Double toan;

    private Double van;

    private Double anh;

    public StudentScore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Double getToan() {
        return toan;
    }

    public void setToan(Double toan) {
        this.toan = toan;
    }

    public Double getVan() {
        return van;
    }

    public void setVan(Double van) {
        this.van = van;
    }

    public Double getAnh() {
        return anh;
    }

    public void setAnh(Double anh) {
        this.anh = anh;
    }
}