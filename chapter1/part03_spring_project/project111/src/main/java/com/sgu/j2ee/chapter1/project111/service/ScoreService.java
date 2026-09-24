package com.sgu.j2ee.chapter1.project111.service;

import com.sgu.j2ee.chapter1.project111.model.CandidateScore;
import com.sgu.j2ee.chapter1.project111.repository.CandidateScoreRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private CandidateScoreRepository repository;

    // 1. Logic lưu danh sách vào CSDL (đọc từ Excel)
    public void importExcelData(MultipartFile file) throws Exception {
        List<CandidateScore> scores = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Bỏ qua dòng tiêu đề

            CandidateScore score = new CandidateScore();
            score.setMssv(row.getCell(0).getStringCellValue());
            score.setFullName(row.getCell(1).getStringCellValue());
            score.setMathScore(row.getCell(2).getNumericCellValue());
            score.setLiteratureScore(row.getCell(3).getNumericCellValue());
            score.setEnglishScore(row.getCell(4).getNumericCellValue());

            scores.add(score);
        }

        repository.saveAll(scores); // Lưu toàn bộ vào CSDL
        workbook.close();
    }

    // 2. Logic tra cứu điểm theo MSSV
    public Optional<CandidateScore> findScoreByMssv(String mssv) {
        return repository.findByMssv(mssv);
    }

    // 3. Logic xác thực CAPTCHA bằng RestTemplate
    public boolean verifyRecaptcha(String recaptchaResponse) {
        String recaptchaSecret = "6LeK58wtAAAAAH_kjMcHGLtHKFTs377qVdvYQ3Q0";
        String verifyUrl = "https://www.google.com/recaptcha/api/siteverify?secret="
                + recaptchaSecret + "&response=" + recaptchaResponse;

        RestTemplate restTemplate = new RestTemplate();
        // Gọi API của Google và lấy kết quả trả về dưới dạng Map
        Map<String, Object> response = restTemplate.postForObject(verifyUrl, null, Map.class);

        if (response != null) {
            return (Boolean) response.get("success"); // Trả về true nếu là người thật
        }
        return false;
    }

    public void importExcelDataFromResource() throws Exception {
        // Tự động tìm file xlsx trong thư mục resources
        java.io.InputStream inputStream = getClass().getResourceAsStream("/Diem_Thi_THPT.xlsx");

        if (inputStream != null) {
            org.apache.poi.ss.usermodel.Workbook workbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
            java.util.List<CandidateScore> scores = new java.util.ArrayList<>();

            // Duyệt qua từng dòng trong trang tính
            for (org.apache.poi.ss.usermodel.Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Bỏ qua dòng đầu tiên (tiêu đề)

                CandidateScore score = new CandidateScore();

                // Đọc và in MSSV ra console để kiểm tra định dạng
                score.setMssv(row.getCell(0).getStringCellValue());
                System.out.println("Đã đọc MSSV từ Excel: [" + score.getMssv() + "]");

                // Đọc các thông tin còn lại
                score.setFullName(row.getCell(1).getStringCellValue());
                score.setMathScore(row.getCell(2).getNumericCellValue());
                score.setLiteratureScore(row.getCell(3).getNumericCellValue());
                score.setEnglishScore(row.getCell(4).getNumericCellValue());

                scores.add(score);
            }

            repository.saveAll(scores);
            workbook.close();
        } else {
            System.out.println("Lỗi: Không tìm thấy file Diem_Thi_THPT.xlsx!");
        }
    }
}
