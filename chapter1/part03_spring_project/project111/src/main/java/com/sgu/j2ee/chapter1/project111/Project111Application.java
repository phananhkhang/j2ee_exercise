package com.sgu.j2ee.chapter1.project111;

import com.sgu.j2ee.chapter1.project111.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project111Application implements CommandLineRunner {
	// Khai báo ScoreService
	@Autowired
	private ScoreService scoreService;

	public static void main(String[] args) {
		SpringApplication.run(Project111Application.class, args);
	}

	// Hàm này sẽ tự động chạy ngay khi ứng dụng khởi động xong
	@Override
	public void run(String... args) throws Exception {
		System.out.println("🔄 Đang nạp dữ liệu điểm thi từ file Excel...");
		scoreService.importExcelDataFromResource();
		System.out.println("✅ Nạp dữ liệu thành công! Ứng dụng đã sẵn sàng tra cứu.");
	}
}
