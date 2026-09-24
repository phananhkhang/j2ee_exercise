package com.sgu.j2ee.chapter1.project111.model;

import jakarta.persistence.*;

@Entity
public class CandidateScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;     // Khóa chính tự tăng

    @Column(unique = true) // MSSV là duy nhất không được trùng
    private String mssv, fullName;
    private double mathScore, literatureScore, englishScore;

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public String getMssv(){return mssv;}
    public void setMssv(String mssv){this.mssv = mssv;}

    public String getFullName(){return fullName;}
    public void setFullName(String fullName){this.fullName = fullName;}

    public double getMathScore(){return mathScore;}
    public void setMathScore(double mathScore){this.mathScore = mathScore;}

    public double getLiteratureScore(){return literatureScore;}
    public void setLiteratureScore(double literatureScore){this.literatureScore = literatureScore;}

    public double getEnglishScore(){return englishScore;}
    public void setEnglishScore(double englishScore){this.englishScore = englishScore;}
}
