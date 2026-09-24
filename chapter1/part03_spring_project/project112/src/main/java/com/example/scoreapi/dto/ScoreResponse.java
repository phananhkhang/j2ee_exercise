package com.example.scoreapi.dto;

public class ScoreResponse {

    private String sbd;
    private String hoTen;
    private Double toan;
    private Double van;
    private Double anh;

    public ScoreResponse(
            String sbd,
            String hoTen,
            Double toan,
            Double van,
            Double anh) {

        this.sbd = sbd;
        this.hoTen = hoTen;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }

    public String getSbd() {
        return sbd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Double getToan() {
        return toan;
    }

    public Double getVan() {
        return van;
    }

    public Double getAnh() {
        return anh;
    }
}