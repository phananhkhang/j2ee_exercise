package com.sgu.j2ee.chapter1.project111.repository;

import com.sgu.j2ee.chapter1.project111.model.CandidateScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CandidateScoreRepository extends JpaRepository<CandidateScore, Integer>{
    // Chỉ cần đặt tên hàm theo đúng quy tắc (findBy + TênThuộcTính),
    // Spring Boot sẽ tự hiểu là bạn muốn tìm kiếm thí sinh theo cột mssv.
    Optional<CandidateScore> findByMssv(String mssv);
}
