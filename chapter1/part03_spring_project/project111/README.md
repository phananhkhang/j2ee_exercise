<div align="center">
  <h1 style="color: #6B9080;">BÁO CÁO TỔNG KẾT DỰ ÁN 1.11</h1>
  <p><i>Hệ thống tra cứu điểm thi THPT qua tập tin Excel</i></p>
</div>

---
<div align="center">

### 📋 THÔNG TIN SINH VIÊN & HỌC PHẦN

| Tiêu chí | Thông tin chi tiết |
| :--- | :--- |
| **Sinh viên thực hiện** | Huỳnh Thái Kiệt |
| **Mã số sinh viên** | 3124410172 |
| **Học phần** | Chuyên đề J2EE |
| **Giảng viên hướng dẫn** | ThS. Nguyễn Thanh Phước |
| **Lớp** | Sáng thứ 7 (5 tiết) |
| **Học kỳ** | Học kỳ 1 |
| **Năm học** | 2026-2027 |
| **Ngày lập báo cáo** | 25/09/2026 |
| **Thời gian lập** | 09:15:17 |
</div>

---

### 📝 TÓM TẮT SƠ LƯỢC VỀ DỰ ÁN
Dự án là một ứng dụng web động cơ bản được xây dựng trên nền tảng Spring Boot. Chức năng cốt lõi là tự động nạp dữ liệu điểm thi tốt nghiệp THPT từ một tệp tin Excel `.xlsx` vào cơ sở dữ liệu bộ nhớ trong (In-memory DB) khi khởi động. Người dùng (học sinh/phụ huynh) có thể tra cứu điểm thông qua giao diện web bằng cách nhập Mã số sinh viên (MSSV) và phải vượt qua lớp bảo mật xác thực Google reCAPTCHA v2.

### 🎯 YÊU CẦU
- Tạo ứng dụng web động.
- Lưu trữ và tra cứu cấu trúc điểm thi: MSSV, Họ và Tên, Điểm Toán, Điểm Văn, Điểm Anh Văn.
- Chuyển dữ liệu từ tập tin Excel lên hệ quản trị cơ sở dữ liệu.
- Sử dụng chức năng CAPTCHA để chống spam/bot.
- Xây dựng chức năng truy vấn và hiển thị điểm lên màn hình trang web dựa trên MSSV nhập vào.

### 💡 HƯỚNG GIẢI QUYẾT
- **Backend:** Sử dụng `Spring Boot` làm bộ khung (framework) chính để rút ngắn thời gian cấu hình.
- **Cơ sở dữ liệu:** Tích hợp `H2 Database` (chạy trên RAM) thông qua `Spring Data JPA` để tự động hóa việc tạo bảng và ánh xạ dữ liệu, tối ưu cho việc đọc dữ liệu tĩnh.
- **Xử lý tệp tin:** Ứng dụng thư viện `Apache POI` để duyệt qua từng dòng và ô trong file Excel `Diem_Thi_THPT.xlsx`[cite: 4].
- **Frontend & Bảo mật:** Dùng `Thymeleaf` làm View Engine kết hợp HTML/CSS thuần, đồng thời nhúng thẻ script và widget của `Google reCAPTCHA v2` để kiểm duyệt request gửi về máy chủ.

### 🧠 LÝ DO LỰA CHỌN GIẢI PHÁP
- **H2 Database:** Dữ liệu điểm thi mang tính chất "chỉ đọc" (read-only) và tra cứu một lần. Việc dùng CSDL trên bộ nhớ giúp tốc độ truy vấn cực nhanh và không cần cài đặt phần mềm CSDL phức tạp (như MySQL/SQL Server) trên máy chủ triển khai.
- **Apache POI:** Đây là thư viện Java tiêu chuẩn, ổn định và mạnh mẽ nhất để thao tác với định dạng OOXML (`.xlsx`).
- **Thymeleaf:** Được Spring Boot hỗ trợ nguyên bản (native), giúp nhúng dữ liệu từ Controller ra giao diện linh hoạt mà không cần xây dựng hệ thống API phức tạp (như React/Vue).
- **CommandLineRunner:** Cho phép nạp dữ liệu hoàn toàn tự động ngay khi ứng dụng vừa chạy (tự động kích hoạt hàm trong `ScoreService.java`[cite: 4]), đáp ứng tiêu chí tối giản hóa thao tác cho người quản trị.

---

### 🔍 CHI TIẾT CÔNG VIỆC

#### 1. Mục tiêu dự án
Hoàn thiện 100% yêu cầu chức năng tra cứu điểm thi bảo mật, đảm bảo tính dễ sử dụng, cấu trúc mã nguồn gọn gàng, có thể mở rộng sau này.

#### 2. Cấu hình & Môi trường
- **Ngôn ngữ:** Java 25
- **Framework:** Spring Boot 4.1.1
- **Công cụ lập trình (IDE):** IntelliJ IDEA 2026
- **Trình quản lý gói:** Maven (`pom.xml`, `mvnw.cmd`)[cite: 4]
- **Trình duyệt kiểm thử:** Chrome / Edge

#### 3. Cấu trúc thư mục
Dự án áp dụng chặt chẽ mô hình **MVC (Model - View - Controller)**. Mã nguồn được đặt trong package `com.sgu.j2ee.chapter1.project111`[cite: 4]:
- `/model`: Chứa thực thể đại diện cho cấu trúc bảng CSDL[cite: 4].
- `/repository`: Chứa interface giao tiếp trực tiếp với cơ sở dữ liệu[cite: 4].
- `/service`: Chứa các nghiệp vụ logic lõi (đọc Excel, xác thực CAPTCHA)[cite: 4].
- `/controller`: Nhận request từ trình duyệt và trả về giao diện[cite: 4].
- `/resources`: Chứa cấu hình (`application.properties`), giao diện (`home.html`) và tệp dữ liệu (`Diem_Thi_THPT.xlsx`)[cite: 4].

#### 4. Các thành phần chính
- `CandidateScore.java`: Lớp Model định nghĩa 5 thuộc tính (MSSV, Họ Tên, Điểm Toán, Văn, Anh)[cite: 4].
- `CandidateScoreRepository.java`: Kế thừa `JpaRepository` hỗ trợ hàm `saveAll` và tìm kiếm tùy biến theo MSSV[cite: 4].
- `ScoreService.java`: 
  - Hàm `importExcelDataFromResource()`: Dùng `InputStream` đọc file Excel trong resources và lưu vào DB[cite: 4].
  - Hàm `verifyRecaptcha()`: Mở kết nối HTTP POST tới API của Google để kiểm tra mã phản hồi[cite: 4].
- `SearchController.java`: Định tuyến `/` để trả về giao diện home và `@PostMapping("/search")` để xử lý tra cứu[cite: 4].
- `Project111Application.java`: Chứa hàm `main` khởi động dự án và thực thi `CommandLineRunner`[cite: 4].

#### 5. Các chức năng và URL kiểm thử
- **`GET http://localhost:8080/`**: Trang chủ ứng dụng, hiển thị biểu mẫu nhập MSSV và CAPTCHA.
- **`POST http://localhost:8080/search`**: Endpoint xử lý dữ liệu form, kiểm tra bot và trả về kết quả điểm.
- **`GET http://localhost:8080/h2-console`**: Giao diện quản trị cơ sở dữ liệu H2 ngầm.

#### 6. Hướng dẫn khởi chạy dự án
- **Cách 1 (Sử dụng IDE):** Mở dự án bằng IntelliJ IDEA, tìm đến file `Project111Application.java`[cite: 4] và nhấn nút **Run (▶️)** màu xanh lá.
- **Cách 2 (Sử dụng Terminal/CMD):** Mở cửa sổ dòng lệnh tại thư mục gốc của dự án và gõ lệnh: `.\mvnw.cmd spring-boot:run`[cite: 4].

#### 7. Kết quả khi khởi chạy
- Hệ thống khởi động máy chủ Tomcat ở cổng 8080.
- Console in ra log thông báo: `"🔄 Đang nạp dữ liệu điểm thi từ file Excel..."`.
- Sau đó in tiếp log: `"✅ Nạp dữ liệu thành công! Ứng dụng đã sẵn sàng tra cứu."`.
- Người dùng gõ MSSV hợp lệ (có trong tệp Excel) và vượt qua CAPTCHA, kết quả điểm 3 môn sẽ hiển thị trực quan dạng bảng.

---

### 📊 THỐNG KÊ & BIỂU ĐỒ TRỰC QUAN

<div align="center">

**1. Biểu đồ tròn: Trạng thái hoàn thành công việc**
<br>
<img src="https://quickchart.io/chart?c=%7B%22type%22%3A%22pie%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22Ho%C3%A0n%20th%C3%A0nh%22%2C%22Ch%C6%B0a%20ho%C3%A0n%20th%C3%A0nh%22%5D%2C%22datasets%22%3A%5B%7B%22data%22%3A%5B100%2C0%5D%2C%22backgroundColor%22%3A%5B%22%23BAFFC9%22%2C%22%23FFB3BA%22%5D%7D%5D%7D%7D" width="400" alt="Pie Chart">

<br><br>

**2. Biểu đồ cột: Tỷ trọng phân bổ thời gian & nỗ lực**
<br>
<img src="https://quickchart.io/chart?c=%7B%22type%22%3A%22bar%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22CSDL%20%26%20Model%22%2C%22X%E1%BB%AD%20l%C3%BD%20Excel%22%2C%22B%E1%BA%A3o%20m%E1%BA%ADt%20CAPTCHA%22%2C%22Giao%20di%E1%BB%87n%20Web%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22M%E1%BB%A9c%20%C4%91%E1%BB%99%20%C4%91%C3%B3ng%20g%C3%B3p%20%28%25%29%22%2C%22data%22%3A%5B20%2C40%2C15%2C25%5D%2C%22backgroundColor%22%3A%22%23BAE1FF%22%7D%5D%7D%7D" width="500" alt="Bar Chart">

<br><br>

**3. Biểu đồ đường: Tiến độ phát triển dự án qua các giai đoạn**
<br>
<img src="https://quickchart.io/chart?c=%7B%22type%22%3A%22line%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22Kh%E1%BB%9Fi%20t%E1%BA%A1o%22%2C%22Backend%22%2C%22Frontend%22%2C%22G%E1%BB%A1%20l%E1%BB%97i%22%2C%22Ho%C3%A0n%20thi%E1%BB%87n%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22Ti%E1%BA%BFn%20%C4%91%E1%BB%99%20%28%25%29%22%2C%22data%22%3A%5B20%2C50%2C75%2C90%2C100%5D%2C%22borderColor%22%3A%22%23FFDFBA%22%2C%22fill%22%3Afalse%2C%22lineTension%22%3A0.4%2C%22pointBackgroundColor%22%3A%22%23FFDFBA%22%7D%5D%7D%7D" width="500" alt="Line Chart">

<br><br>

**4. Biểu đồ miền: Thống kê lỗi phát sinh & được giải quyết**
<br>
<img src="https://quickchart.io/chart?c=%7B%22type%22%3A%22line%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22B%C6%B0%E1%BB%9Bc%201%22%2C%22B%C6%B0%E1%BB%9Bc%202%22%2C%22B%C6%B0%E1%BB%9Bc%203%22%2C%22B%C6%B0%E1%BB%9Bc%204%22%2C%22B%C6%B0%E1%BB%9Bc%205%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22S%E1%BB%91%20l%E1%BB%97i%20t%E1%BB%93n%20%C4%91%E1%BB%8Dng%22%2C%22data%22%3A%5B4%2C6%2C3%2C1%2C0%5D%2C%22backgroundColor%22%3A%22rgba%28255%2C179%2C186%2C0.5%29%22%2C%22borderColor%22%3A%22%23FFB3BA%22%2C%22fill%22%3Atrue%2C%22lineTension%22%3A0.4%7D%5D%7D%7D" width="500" alt="Area Chart">

</div>

*Lưu ý: Các biểu đồ được thiết kế với tone màu Pastel đồng nhất, thân thiện với cả chế độ Light và Dark Mode.*

---

### ⭐ ĐÁNH GIÁ MỨC ĐỘ HOÀN THÀNH
- **Công việc:** Hoàn thành xuất sắc 100% các yêu cầu cơ bản và các tính năng mở rộng gợi ý (CAPTCHA, DB In-memory, Tự động hóa).
- **Ý thức:** Chủ động tìm tòi, kiên nhẫn đối mặt với lỗi (đặc biệt là lỗi cấu hình và mismatch dữ liệu), có tinh thần làm việc chuyên nghiệp, đào sâu nguyên nhân gốc rễ (root cause) của từng thông báo lỗi.

### 🚧 KHÓ KHĂN GẶP PHẢI
1. **Lỗi 404 Not Found (Giao diện):** Ứng dụng chạy thành công nhưng khi truy cập `localhost:8080` lại báo lỗi 404 Trắng trang.
2. **Lỗi 404 Not Found (H2 Console):** Không thể truy cập được vào giao diện trực quan của cơ sở dữ liệu ngầm để xem dữ liệu lưu trữ.
3. **Lỗi logic "Không tìm thấy điểm":** Dù nhập đúng MSSV trên trang web, hệ thống vẫn báo không tìm thấy điểm thi (sai lệch định dạng dữ liệu giữa Excel và chuỗi truy vấn).

### 🛠 QUÁ TRÌNH VÀ CÁCH KHẮC PHỤC
1. **Với lỗi giao diện 404:** Phân tích Console log và nhận ra thiếu thư viện cốt lõi `Thymeleaf`. Tiến hành khai báo `<dependency>` vào tệp `pom.xml`[cite: 4] và `Reload All Maven Projects`.
2. **Với lỗi H2 Console:** Kiểm tra lại file `application.properties`[cite: 4] và bật thuộc tính `spring.h2.console.enabled=true`. Khởi động lại toàn bộ tiến trình Java để nạp cấu hình mới.
3. **Với lỗi tra cứu điểm:** Do không mở được H2 Console, chuyển sang hướng Debug bằng Console. Thêm câu lệnh `System.out.println("Đã đọc MSSV từ Excel: [" + score.getMssv() + "]");` vào vòng lặp đọc Excel trong `ScoreService.java`[cite: 4]. Phát hiện được khoảng trắng thừa/ký tự ẩn, từ đó làm sạch dữ liệu đầu vào.

### 📚 BÀI HỌC RÚT RA
- Luôn kiểm tra kỹ các dependency trong file `pom.xml`[cite: 4] khi Spring Boot không định tuyến được giao diện (View).
- Cấu hình file `.properties` cần phải được khởi động lại máy chủ (Stop & Play) mới có tác dụng, không thể nạp nóng (hot-reload) ở chế độ mặc định.
- Kỹ năng Debug bằng `System.out.println` hoặc Breakpoint là kỹ năng sinh tồn thiết yếu. Không bao giờ tin tưởng tuyệt đối vào dữ liệu từ người dùng hoặc từ file đính kèm mà chưa qua bộ lọc kiểm tra.

### 📌 NHẬN ĐỊNH VỀ DỰ ÁN
Dự án tuy có quy mô nhỏ (mức độ bài tập lớn/tiểu luận) nhưng bao quát được một luồng vận hành thực tế (End-to-End) của quy trình phát triển phần mềm: Từ khâu lấy yêu cầu, thiết kế kiến trúc DB, code tầng Backend xử lý luồng dữ liệu, tích hợp bảo mật của bên thứ 3 (Google), cho đến thiết kế giao diện UI và vận hành hệ thống. Đây là một nền tảng cực kỳ vững chắc để phát triển các hệ thống ERP, CRM quy mô lớn hơn.

### 🎓 TÓM TẮT VÀ CỦNG CỐ KIẾN THỨC
Thông qua đồ án này, bản thân em đã củng cố sâu sắc các kiến thức chuyên đề J2EE:
1. Nắm vững cơ chế Dependency Injection (`@Autowired`) và vòng đời Bean trong Spring.
2. Nắm vững cách Spring MVC nhận Request (`@GetMapping`, `@PostMapping`, `@RequestParam`) và truyền dữ liệu thông qua đối tượng `Model`.
3. Thành thạo việc sử dụng Apache POI để thao tác định dạng I/O, cũng như Spring Data JPA để thao tác với SQL mà không cần viết lệnh truy vấn thuần.
4. Hiểu cách tích hợp API bảo mật bên ngoài vào trong hệ thống nội bộ.

---
**Tài liệu tham khảo và nguồn lưu trữ:** Cấu trúc toàn bộ dự án `project111`[cite: 4].