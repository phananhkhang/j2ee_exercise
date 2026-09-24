# 🚀 BÁO CÁO TỔNG KẾT DỰ ÁN 1.7: XÂY DỰNG ỨNG DỤNG RESTFUL API VỚI SPRING BOOT

## 📋 THÔNG TIN SINH VIÊN

| Trạng thái | Thuộc tính | Chi tiết |
| :--- | :--- | :--- |
| 🧑‍🎓 | **Họ và tên** | **Huỳnh Thái Kiệt** |
| 🆔 | **MSSV** | 3124410172 |
| 📚 | **Học phần** | Chuyên đề J2EE |
| 🏫 | **Lớp** | Sáng thứ 7 (5 tiết) |
| 🗓️ | **Học kỳ** | 1 |
| 🎓 | **Năm học** | 2026-2027 |
| ⏱️ | **Thời gian lập báo cáo** | 25/09/2026 - 12:59:13 |

---

## 🌟 TÓM TẮT SƠ LƯỢC VỀ DỰ ÁN

Dự án này là bước khởi đầu để làm quen với hệ sinh thái Spring thông qua việc tự xây dựng một ứng dụng web cơ bản. Dự án minh họa cách thiết lập một **RESTful API** trả về phản hồi văn bản, cách viết các bài kiểm thử tự động (**Unit Test**) giả lập môi trường web với `MockMvc`, và cách tích hợp công cụ giám sát sức khỏe ứng dụng **Spring Boot Actuator**. Toàn bộ dự án được quản lý và biên dịch bằng **Maven Wrapper**.

> **🎯 Yêu cầu dự án:**
> "Tạo dự án có trong bài viết https://spring.io/guides/gs/spring-boot (một hướng dẫn từ chính hãng Spring) giúp các bạn làm quen với đọc tài liệu của hãng từ đó có thể dễ dàng đọc các tính năng mới của Spring Boot 4 và Spring Framework 7 nếu có. Dự án này giúp các bạn tạo một dự án RESTFul API đơn giản, cách kiểm tra 1 dự án Spring và cách triển khai theo dõi vận hành một ứng dụng Spring."

---

## 🛠️ CHI TIẾT CÔNG VIỆC

### 1. Mục tiêu dự án
- Nắm vững kiến trúc cốt lõi của một dự án Spring Boot.
- Hiểu và áp dụng các Annotation cơ bản: `@RestController`, `@GetMapping`, `@SpringBootTest`.
- Biết cách thiết lập và sử dụng `MockMvc` để kiểm thử tự động không cần chạy server.
- Triển khai thành công Spring Boot Actuator để theo dõi trạng thái hệ thống.

### 2. Cấu hình & Môi trường
- **Ngôn ngữ:** Java 25
- **Framework:** Spring Boot 4.1.1
- **Công cụ build:** Maven Wrapper (chạy lệnh qua `mvnw` / `mvnw.cmd` không cần cài Maven gốc).

### 3. Cấu trúc thư mục (Tóm tắt)
```text
project17/
├── pom.xml                                     # Chứa cấu hình dependencies (Actuator, Web, Test)
├── mvnw / mvnw.cmd                             # Maven Wrapper chạy trên Mac/Linux/Windows
├── src/main/java/.../project17/
│   ├── Project17Application.java               # Lớp khởi động chính của ứng dụng
│   └── HelloController.java                    # API Controller xử lý Request
└── src/test/java/.../project17/
    └── Project17ApplicationTests.java          # Lớp chứa các bài kiểm thử MockMvc
```

### 4. Các thành phần chính
- **`HelloController.java`**: Lớp đóng vai trò tiếp nhận Request. Phương thức `index()` được gắn `@GetMapping("/")` trả về chuỗi `"Xin chào Spring Boot!"`.
- **`Project17ApplicationTests.java`**: Sử dụng `@SpringBootTest` và `@AutoConfigureMockMvc` để thực hiện kiểm thử tự động, xác minh API trả về đúng chuỗi chữ mong đợi và mã trạng thái HTTP 200 (OK).
- **`pom.xml`**: Nơi bổ sung `spring-boot-starter-actuator` để mở khóa các endpoint vận hành.

### 5. Các chức năng và URL kiểm thử
| Chức năng | Phương thức | Đường dẫn (URL) | Kết quả mong đợi |
| :--- | :---: | :--- | :--- |
| **Trang chủ (API)** | `GET` | `http://localhost:8080/` | Trả về Text: `Xin chào Spring Boot!` |
| **Kiểm tra sức khỏe** | `GET` | `http://localhost:8080/actuator/health` | Trả về JSON: `{"status":"UP"}` |

### 6. Hướng dẫn khởi chạy dự án
- **Chạy ứng dụng (Run):** Mở terminal tại thư mục gốc của dự án và gõ lệnh:
  ```bash
  ./mvnw spring-boot:run
  ```
- **Chạy kiểm thử (Test):** Để chạy automation test mà không cần mở server:
  ```bash
  ./mvnw test
  ```

### 7. Kết quả khi khởi chạy
- **Build Success:** Terminal báo cáo `BUILD SUCCESS` khi chạy test.
- **Thư mục target/:** Hệ thống tự động sinh ra các file `.class` (bytecode) và báo cáo kiểm thử tại thư mục `target/surefire-reports/`.
- **Trải nghiệm thực tế:** Khi mở trình duyệt truy cập các URL kiểm thử, phản hồi hiển thị ngay lập tức, chính xác với cấu hình.

---

## 📊 THỐNG KÊ BÁO CÁO BẰNG BIỂU ĐỒ

*Dưới đây là 4 biểu đồ trực quan hóa dữ liệu quá trình làm việc của dự án:*

### 1. Biểu đồ tròn (Pie Chart): Tỉ lệ hoàn thành công việc
![Biểu đồ tròn](https://quickchart.io/chart?w=500&h=250&c={type:'pie',data:{labels:['Đã%20hoàn%20thành','Chưa%20hoàn%20thành'],datasets:[{data:[100,0],backgroundColor:['%2336a2eb','%23ff6384']}]}})
> *Nhận xét: Hoàn thành 100% các đầu mục công việc được giao.*

### 2. Biểu đồ cột (Bar Chart): Phân bổ thời gian thực hiện (Giờ)
![Biểu đồ cột](https://quickchart.io/chart?w=500&h=250&c={type:'bar',data:{labels:['Khởi%20tạo','Code%20API','Viết%20Test','Actuator','Viết%20Báo%20cáo'],datasets:[{label:'Thời%20gian%20(Giờ)',data:[1,2,3,1.5,2],backgroundColor:'%234bc0c0'}]}})
> *Nhận xét: Thời gian tập trung nhiều nhất vào việc tìm hiểu và viết Unit Test cho Spring Boot.*

### 3. Biểu đồ đường (Line Chart): Mức độ khó khăn qua từng giai đoạn
![Biểu đồ đường](https://quickchart.io/chart?w=500&h=250&c={type:'line',data:{labels:['Đọc%20tài%20liệu','Khởi%20tạo','Code%20Controller','Viết%20Test','Tích%20hợp%20Actuator'],datasets:[{label:'Độ%20khó%20(Thang%201-10)',data:[6,2,3,8,4],borderColor:'%23ff9f40',fill:false}]}})
> *Nhận xét: Giai đoạn viết Test với MockMvc là thách thức lớn nhất do nhiều annotation mới.*

### 4. Biểu đồ miền (Area Chart): Năng lượng và sự tập trung 
![Biểu đồ miền](https://quickchart.io/chart?w=500&h=250&c={type:'line',data:{labels:['Bắt%20đầu','Lập%20trình','Gặp%20lỗi','Khắc%20phục','Hoàn%20thiện'],datasets:[{label:'Mức%20độ%20tập%20trung%20(%)',data:[50,85,95,100,80],fill:true,backgroundColor:'rgba(153,%20102,%20255,%200.2)',borderColor:'%239966ff'}]}})
> *Nhận xét: Năng lượng học tập đạt đỉnh khi debug và tìm cách khắc phục lỗi.*

---

## 📝 ĐÁNH GIÁ VÀ NHÌN NHẬN

### Đánh giá mức độ hoàn thành
- **Công việc:** Hoàn thành xuất sắc 100% yêu cầu (Tạo RESTful API, Kiểm thử, Theo dõi vận hành).
- **Ý thức:** Chăm chỉ, chủ động đào sâu tài liệu gốc của Spring, kết hợp công cụ AI để phân tích và hệ thống hóa lại kiến thức.

### Khó khăn gặp phải
1. Lúc đầu chưa quen với cú pháp dòng lệnh của Maven (`./mvnw`).
2. Nhầm lẫn giữa các annotation khởi tạo môi trường test (`@SpringBootTest` vs `@WebMvcTest`).
3. Choáng ngợp với lượng cấu hình ẩn tự động (Auto-configuration) của Spring Boot.

### Quá trình và cách khắc phục
- Đọc lại kỹ phần giải thích tài liệu từ hãng và ghi chú lại sự khác biệt.
- Sử dụng cách phân tích "Từng bước một" thay vì sao chép toàn bộ code.
- Mở xem trực tiếp kết quả sinh ra trong thư mục `target/` để hiểu rõ quá trình trình biên dịch của Maven.

### Bài học rút ra
- Không cần phải ghi nhớ tất cả cấu hình, quan trọng là hiểu "luồng đi" (Flow) của dữ liệu: `Request -> Controller -> Response`.
- Luôn luôn phải viết Unit Test. Đó không phải là bước phụ, mà là tiêu chuẩn kỹ sư phần mềm.
- Spring Boot Actuator là một vũ khí cực kỳ mạnh mẽ để giám sát Production mà không cần tốn công code thêm chức năng quản lý.

### Nhận định về dự án
Đây là một dự án nền tảng vô cùng quan trọng. Tuy quy mô nhỏ nhưng nó chứa đựng đầy đủ các khái niệm cốt lõi (Core concepts) của J2EE và Spring Boot hiện đại, là tiền đề để phát triển các hệ thống Microservices phức tạp sau này.

### 🧠 Tóm tắt và củng cố kiến thức
1. **`@RestController` + `@GetMapping`** = Xây dựng nhanh một API tiếp nhận dữ liệu.
2. **`MockMvc`** = Gửi Request giả lập để test Controller, bỏ qua khâu khởi động web server chậm chạp.
3. **`Actuator`** = Chỉ cần khai báo trong `pom.xml`, hệ thống tự sinh ra các đường link (`/actuator/health`) để đo lường sức khỏe ứng dụng.
4. **`mvnw`** = Maven Wrapper bảo đảm code chạy mượt mà trên mọi máy tính mà không lo lệch phiên bản.

---
*Báo cáo được biên soạn và trình bày bởi Huỳnh Thái Kiệt - Đã sẵn sàng nộp và áp dụng cho các dự án thực tế sắp tới!* ✨