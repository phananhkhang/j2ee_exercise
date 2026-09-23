# Project 1.14: Customer Service Feedback Web Application (ServicePulse)

Dự án ứng dụng web thu thập và quản lý thông tin phản hồi của khách hàng về chất lượng dịch vụ (Customer CSAT & Experience Feedback System), được xây dựng với **Java 25**, **Spring Boot 4.1.1** và **Thymeleaf**, áp dụng các tiêu chuẩn thiết kế hiện đại từ **Frontend Developer**.

---

## 1. Yêu cầu & Gợi ý thực hiện của bài tập

### a) Màn hình phản hồi dịch vụ tham khảo trên mạng
- Ứng dụng lấy cảm hứng từ form khảo sát đo lường chỉ số hài lòng khách hàng (**CSAT - Customer Satisfaction Score**) phổ biến của các nền tảng công nghệ hàng đầu như **Grab, Shopee, Agoda, Apple Support**.
- **Các thành phần cốt lõi của màn hình khảo sát chuẩn:**
  1. Header nhận diện dịch vụ và lời kêu gọi phản hồi chân thành.
  2. Thông tin khách hàng (Họ tên, Email, Số điện thoại).
  3. Phân loại dịch vụ đã trải nghiệm (Kỹ thuật, Giao hàng, CSKH, Bảo hành).
  4. Đánh giá xếp hạng sao tương tác (Interactive 5-star Rating) kết hợp biểu cảm Emoji (1★ Rất không hài lòng 😡 đến 5★ Rất hài lòng 🤩).
  5. Đánh giá đa chiều theo tiêu chí (Thái độ phục vụ, Tốc độ hỗ trợ).
  6. Ý kiến đóng góp & chia sẻ chi tiết (Textarea).
  7. Câu hỏi đo lường NPS: Sẵn sàng giới thiệu dịch vụ cho bạn bè, người thân.
  8. Trang thông báo cảm ơn (Thank You page) hiển thị tóm tắt thông tin đã tiếp nhận.
  9. Bảng điều khiển quản trị (Feedback Management Dashboard) hiển thị các chỉ số KPI: Tổng số phản hồi, Điểm trung bình CSAT, Tỷ lệ khuyên dùng, cùng bảng danh sách phản hồi chi tiết.

### b) Triển khai cài đặt vào dự án
- Toàn bộ giao diện được tích hợp hoàn chỉnh vào Spring Boot MVC + Thymeleaf, phục vụ qua các đường dẫn `GET /feedback`, `POST /feedback`, `GET /feedback/success`, và `GET /feedbacks`.
- Dữ liệu được lưu trữ linh hoạt trong tầng Service (`FeedbackService`) với các bản ghi mẫu sẵn sàng trải nghiệm.

### c) Prompt mẫu đã sử dụng để sinh mã nguồn HTML, CSS hiện đại
```text
"Hãy đóng vai trò là Senior Frontend Developer, thiết kế một màn hình web khảo sát phản hồi dịch vụ khách hàng (Customer Service Feedback) thật hiện đại, sạch sẽ và chuyên nghiệp:
- Bảng màu: Chủ đạo xanh dương công nghệ (#2563eb), điểm nhấn vàng hổ phách (#f59e0b) cho các ngôi sao đánh giá.
- UX/UI: Đánh giá 5 sao tương tác bằng JavaScript với hiệu ứng hover và cập nhật nhãn cảm xúc trực quan. Thang điểm phụ cho thái độ nhân viên và tốc độ xử lý.
- Đảm bảo tính tiếp cận (Accessibility WCAG 2.1 AA), responsive mobile-first trên mọi thiết bị.
- Tích hợp chuẩn cú pháp Spring Boot Thymeleaf (th:object, th:field, th:action, th:each, th:if, @{...})."
```

---

## 2. Cấu hình & Môi trường
- **Java**: 25
- **Spring Boot**: 4.1.1
- **Package name**: `com.sgu.j2ee.chapter1.project114`
- **Thư mục dự án**: `chapter1/part03_spring_project/project114`

---

## 3. Cấu trúc thư mục

```
project114/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/wrapper/maven-wrapper.properties
└── src/
    ├── main/
    │   ├── java/com/sgu/j2ee/chapter1/project114/
    │   │   ├── Project114Application.java
    │   │   ├── controller/
    │   │   │   └── FeedbackController.java
    │   │   ├── model/
    │   │   │   └── Feedback.java
    │   │   └── service/
    │   │       └── FeedbackService.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/
    │       │   ├── css/
    │       │   │   └── style.css
    │       │   └── js/
    │       │       └── feedback.js
    │       └── templates/
    │           ├── feedback-form.html
    │           ├── feedback-list.html
    │           └── feedback-success.html
    └── test/
        └── java/com/sgu/j2ee/chapter1/project114/
            └── Project114ApplicationTests.java
```

---

## 4. Các chức năng & URL kiểm thử

| Đường dẫn (URL) | Phương thức | Mô tả |
|-----------------|-------------|-------|
| `http://localhost:8080/` hoặc `/feedback` | GET | Màn hình khảo sát ý kiến & đánh giá dịch vụ khách hàng với widget chọn sao tương tác. |
| `http://localhost:8080/feedback` | POST | Tiếp nhận form dữ liệu gửi lên, kiểm tra tính hợp lệ và lưu trữ vào danh sách. |
| `http://localhost:8080/feedback/success` | GET | Trang xác nhận gửi phản hồi thành công kèm thẻ tóm tắt chi tiết. |
| `http://localhost:8080/feedbacks` | GET | Bảng điều khiển quản trị: Hiển thị các thẻ KPI (Tổng phản hồi, CSAT trung bình, % Khuyên dùng) và bảng danh sách phản hồi. |

---

## 5. Hướng dẫn khởi chạy ứng dụng

Tại thư mục `chapter1/part03_spring_project/project114`:

```powershell
.\mvnw.cmd spring-boot:run
```

Sau khi ứng dụng khởi chạy thành công:
1. Mở trình duyệt truy cập `http://localhost:8080/feedback` để trải nghiệm form đánh giá dịch vụ.
2. Điền thông tin, chọn sao và nhấn **Gửi phản hồi của bạn**.
3. Xem bảng tổng hợp kết quả tại `http://localhost:8080/feedbacks`.
