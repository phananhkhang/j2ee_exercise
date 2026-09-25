<div align="center">

# 🌟 BÁO CÁO TỔNG KẾT DỰ ÁN 🌟
**Môn học: Chuyên đề J2EE**

---

| Thông tin | Chi tiết |
| :--- | :--- |
| **Họ và tên sinh viên** | **Huỳnh Thái Kiệt** |
| **Mã số sinh viên (MSSV)** | `3124410172` |
| **Giảng viên hướng dẫn** | ThS. Nguyễn Thanh Phước |
| **Lớp học** | Sáng thứ 7 (5 tiết) |
| **Học kỳ** | Học kỳ 1 |
| **Năm học** | 2026 - 2027 |
| **Thời gian báo cáo** | `25/09/2026` - `07:49:06` |

</div>

<br>

## 📝 1. TÓM TẮT SƠ LƯỢC VỀ DỰ ÁN
Dự án `project11` là một bài tập thực hành cốt lõi nhằm làm quen với nền tảng **Spring Boot**. Dự án mô phỏng việc khởi tạo môi trường, thiết lập các đối tượng (Beans) thông qua cấu hình Java thuần túy (`@Configuration`, `@Bean`) thay vì dùng XML, đồng thời ứng dụng nguyên lý **Inversion of Control (IoC)** và **Dependency Injection (DI)** để truy xuất và thực thi một Service (dịch vụ) trực tiếp từ **Spring Application Context**.

## 🎯 2. YÊU CẦU
1. **Khởi tạo** dự án Java cơ bản với Maven.
2. **Tạo lập lớp `GreetingService`** mang biến thành viên `message`.
3. **Cấu hình Spring Bean** qua lớp `AppConf` bằng ngôn ngữ Java.
4. **Khởi động Spring Context** bằng `SpringApplication.run()` và gọi phương thức thực thi của Bean.

## 💡 3. HƯỚNG GIẢI QUYẾT
- Sử dụng **Maven** (`pom.xml`) để quản lý các thư viện (dependencies) của Spring Boot.
- Định hình cấu trúc package chuẩn xác: `com.sgu.j2ee.chapter1.project11`.
- Sử dụng annotation `@SpringBootApplication` để tự động hóa cấu hình cơ sở.
- Triển khai mô hình Constructor Injection (truyền tham số qua hàm tạo) cho `GreetingService` để đảm bảo tính toàn vẹn dữ liệu.

## 🧠 4. LÝ DO ÁP DỤNG
Phương pháp này giúp **loại bỏ sự phụ thuộc chặt chẽ (tight coupling)** giữa các lớp mã nguồn. Thay vì hàm `main` phải tự khởi tạo `new GreetingService()`, hệ thống Spring Container sẽ đứng ra quản lý vòng đời của đối tượng này. Việc này tạo tiền đề vững chắc cho các dự án J2EE ở quy mô lớn hơn, nơi mà khả năng mở rộng và bảo trì mã nguồn là yếu tố sống còn.

---

## 🔍 5. CHI TIẾT CÔNG VIỆC

### 📍 5.1. Mục tiêu dự án
Giúp sinh viên nắm vững cách bộ chứa nội tại (Application Context) của Spring Boot hoạt động, cách đăng ký một Bean và cách gọi lại nó để phục vụ cho các xử lý nghiệp vụ.

### 🛠️ 5.2. Cấu hình & Môi trường
- **Ngôn ngữ:** Java 25
- **Framework:** Spring Boot 4.1.1
- **Trình quản lý gói:** Maven Wrapper (`mvnw`)
- **IDE Đề xuất:** IntelliJ IDEA / Eclipse

### 📂 5.3. Cấu trúc thư mục
Được xây dựng chuẩn theo kiến trúc Maven tiêu chuẩn:
```text
project11/
 ┣ src/main/java/com/sgu/j2ee/chapter1/project11/
 ┃ ┣ AppConf.java
 ┃ ┣ GreetingService.java
 ┃ ┗ Project11Application.java
 ┣ src/main/resources/
 ┃ ┗ application.properties
 ┗ pom.xml
```

### 🧩 5.4. Các thành phần chính
1. **`GreetingService.java`**: Chứa logic nghiệp vụ xử lý câu chào (biến `message`) và phương thức in thông tin `printMessage()`.
2. **`AppConf.java`**: Lớp định nghĩa cấu hình, nơi đánh dấu `@Bean` cho hệ thống Spring biết cần phải khởi tạo đối tượng `GreetingService` với nội dung cụ thể.
3. **`Project11Application.java`**: Hàm `main` khởi động hệ thống ứng dụng và truy vấn dữ liệu từ Application Context.

### 🔗 5.5. Các chức năng và URL kiểm thử
- *Lưu ý:* Do dự án hiện tại là ứng dụng Console (chạy trên Terminal) và chưa tích hợp Web Starter (Tomcat nhúng), nên **không có URL kiểm thử (như `localhost:8080`)**. 
- **Chức năng duy nhất:** In lời chào được cấu hình sẵn ra màn hình Terminal khi ứng dụng vừa chạy xong.

### 🚀 5.6. Hướng dẫn khởi chạy dự án
- **Cách 1 (Sử dụng IDE):** Mở tệp `Project11Application.java`, nhấn chuột phải và chọn `Run 'Project11Application.main()'`.
- **Cách 2 (Sử dụng dòng lệnh Maven):**
  Mở terminal tại thư mục gốc của dự án (`project11`) và gõ lệnh:
  ```bash
  ./mvnw spring-boot:run
  ```

### ✅ 5.7. Kết quả khi khởi chạy
Sau khi banner của Spring Boot xuất hiện, màn hình terminal sẽ hiển thị dòng chữ:
> **"Xin chào Spring Boot từ file cấu hình AppConf!"**

---

## 📊 6. THỐNG KÊ & BIỂU ĐỒ TRỰC QUAN

*(Phối màu Pastel thân thiện với giao diện sáng/tối)*

<details open>
<summary><b>📌 Nhấn để xem toàn bộ 4 biểu đồ báo cáo</b></summary>
<br>

<div align="center">

**1. Biểu đồ Tròn (Tỉ trọng các thành phần đã hoàn thành)**  
<br>
<img src="https://quickchart.io/chart?w=400&h=250&c=%7B%22type%22%3A%22pie%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22Kh%E1%BB%9Fi%20t%E1%BA%A1o%20Project%22%2C%22T%E1%BA%A1o%20Service%22%2C%22C%E1%BA%A5u%20h%C3%ACnh%20Bean%22%2C%22Kh%E1%BB%9Fi%20ch%E1%BA%A1y%20Context%22%5D%2C%22datasets%22%3A%5B%7B%22data%22%3A%5B25%2C25%2C25%2C25%5D%2C%22backgroundColor%22%3A%5B%22%23ffb3ba%22%2C%22%23ffdfba%22%2C%22%23ffffba%22%2C%22%23baffc9%22%5D%7D%5D%7D%7D" alt="Pie Chart" width="500"/>

<br><br>

**2. Biểu đồ Cột (Thời gian phân bổ cho từng công việc - Phút)**  
<br>
<img src="https://quickchart.io/chart?w=500&h=250&c=%7B%22type%22%3A%22bar%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22Kh%E1%BB%9Fi%20t%E1%BA%A1o%22%2C%22Vi%E1%BA%BFt%20Code%22%2C%22Kh%E1%BA%AFc%20ph%E1%BB%A5c%20IDE%22%2C%22Ki%E1%BB%83m%20th%E1%BB%AD%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22Th%E1%BB%9Di%20gian%20%28ph%C3%BAt%29%22%2C%22data%22%3A%5B10%2C15%2C8%2C5%5D%2C%22backgroundColor%22%3A%22%23bae1ff%22%2C%22borderRadius%22%3A5%7D%5D%7D%7D" alt="Bar Chart" width="500"/>

<br><br>

**3. Biểu đồ Đường (Mức độ tự tin và tiếp thu kiến thức qua các bước)**  
<br>
<img src="https://quickchart.io/chart?w=500&h=250&c=%7B%22type%22%3A%22line%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22B%E1%BA%AFt%20%C4%91%E1%BA%A7u%22%2C%22B%C6%B0%E1%BB%9Bc%201%22%2C%22B%C6%B0%E1%BB%9Bc%202%22%2C%22B%C6%B0%E1%BB%9Bc%203%22%2C%22Ho%C3%A0n%20th%C3%A0nh%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22M%E1%BB%A9c%20%C4%91%E1%BB%99%20t%E1%BB%B1%20tin%20%28%25%29%22%2C%22data%22%3A%5B30%2C50%2C70%2C85%2C100%5D%2C%22borderColor%22%3A%22%23ffb3ba%22%2C%22backgroundColor%22%3A%22%23ffb3ba%22%2C%22fill%22%3Afalse%2C%22tension%22%3A0.4%2C%22pointRadius%22%3A5%7D%5D%7D%7D" alt="Line Chart" width="500"/>

<br><br>

**4. Biểu đồ Miền (Area Chart - Khối lượng mã nguồn phát triển theo thời gian)**  
<br>
<img src="https://quickchart.io/chart?w=500&h=250&c=%7B%22type%22%3A%22line%22%2C%22data%22%3A%7B%22labels%22%3A%5B%22Giai%20%C4%91o%E1%BA%A1n%201%22%2C%22Giai%20%C4%91o%E1%BA%A1n%202%22%2C%22Giai%20%C4%91o%E1%BA%A1n%203%22%2C%22Giai%20%C4%91o%E1%BA%A1n%204%22%5D%2C%22datasets%22%3A%5B%7B%22label%22%3A%22S%E1%BB%91%20d%C3%B2ng%20code%20%28LoC%29%22%2C%22data%22%3A%5B15%2C35%2C55%2C75%5D%2C%22backgroundColor%22%3A%22rgba%28186%2C225%2C255%2C0.6%29%22%2C%22borderColor%22%3A%22%23bae1ff%22%2C%22fill%22%3Atrue%2C%22tension%22%3A0.3%7D%5D%7D%7D" alt="Area Chart" width="500"/>

</div>

</details>

### 📈 Thống kê chung
- **Số lượng công việc yêu cầu:** 4/4
- **Đã hoàn thành:** 100%
- **Chưa hoàn thành:** 0%

---

## 🏆 7. ĐÁNH GIÁ MỨC ĐỘ HOÀN THÀNH
- **Về mặt công việc:** Hoàn thành xuất sắc và chính xác các yêu cầu đặt ra ban đầu, cấu trúc mã nguồn gọn gàng, đúng chuẩn.
- **Về mặt ý thức:** Chủ động đặt câu hỏi khi gặp lỗi (lỗi không hiển thị tuỳ chọn tạo Java Class), nỗ lực ghi nhớ, tóm tắt và quy hoạch tài liệu rõ ràng.

---

## 🚧 8. KHÓ KHĂN GẶP PHẢI & QUÁ TRÌNH KHẮC PHỤC

**Khó khăn:**
Trong quá trình tạo lớp `GreetingService`, IDE (phần mềm lập trình) đã không nhận diện được thư mục `java` là thư mục chứa mã nguồn. Tuỳ chọn `New -> Java Class` hoàn toàn bị vô hiệu hóa và biến mất khỏi menu ngữ cảnh.

**Quá trình khắc phục:**
1. Phân tích ngữ cảnh và nhận diện đây là một dự án Maven (nhờ có tệp `pom.xml`).
2. Nhận ra IDE chưa tiến hành đồng bộ hóa (sync) dự án.
3. Nhấp chuột phải vào tệp `pom.xml` ở góc dưới cấu trúc thư mục.
4. Lựa chọn **"Add as Maven Project"**.
5. Đợi hệ thống tự động tải `dependencies` và đánh dấu lại thư mục. Biểu tượng thư mục `java` chuyển sang màu xanh (Source Root) và vấn đề được giải quyết.

---

## 🎓 9. BÀI HỌC RÚT RA & NHẬN ĐỊNH VỀ DỰ ÁN

**Bài học rút ra:**
- Học được cách thức tương tác giữa các công cụ quản lý dự án (Maven) và IDE. Nếu IDE "lú", hãy chỉ định cho nó biết nơi lưu trữ thông tin cấu hình (`pom.xml`).
- Hiểu được vòng đời cơ bản của một ứng dụng Spring Boot và cách lấy một đối tượng ra từ "thùng chứa" Application Context.

**Nhận định về dự án:**
Đây là một dự án nhỏ gọn nhưng vô cùng thiết thực. Nó đóng vai trò như một bước đệm hoàn hảo để bước vào thế giới phát triển ứng dụng doanh nghiệp bằng J2EE, giúp tôi làm quen với nguyên lý DI - trái tim của Spring Framework.

---

## 📚 10. TÓM TẮT VÀ CỦNG CỐ KIẾN THỨC
Sự khác biệt cốt lõi giữa **Spring Boot** và **Spring Framework** truyền thống đã được củng cố mạnh mẽ:
*   **Spring Framework** cung cấp nền tảng mạnh mẽ nhưng yêu cầu phải viết rất nhiều tệp cấu hình dài dòng, cấu hình server thủ công.
*   **Spring Boot** khắc phục mọi yếu điểm đó bằng triết lý *"Convention over Configuration"* (Quy ước thay vì Cấu hình). Nó giúp tự động cấu hình (Auto-Configuration), nhúng sẵn Web Server (như Tomcat) và quản lý phiên bản thư viện thông minh (Starters), giúp lập trình viên chỉ việc tập trung vào viết mã nghiệp vụ (Business Logic).

---
*Báo cáo được thực hiện với sự tập trung và tâm huyết cao nhất.* ✨