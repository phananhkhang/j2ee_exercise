# Project 1.9: Spring Boot & Thymeleaf Tutorial

Dự án mẫu minh họa việc tích hợp **Thymeleaf Template Engine** với **Spring Boot** để xây dựng ứng dụng web quản lý danh sách thành viên (Person List) theo bài hướng dẫn [o7planning - Spring Boot and Thymeleaf Tutorial with Examples](https://o7planning.org/11545/spring-boot-and-thymeleaf).

---

## 1. Mục tiêu dự án
- Tích hợp Thymeleaf vào ứng dụng Spring Boot (`spring-boot-starter-thymeleaf`).
- Hiểu cách thức hoạt động của Thymeleaf:
  - Nạp template HTML từ thư mục `src/main/resources/templates/`.
  - Kết hợp dữ liệu từ Model do Spring Controller truyền sang (`th:utext`, `th:each`, `th:field`, `th:action`, `th:object`, `th:if`).
  - Định tuyến URL và Context Path thông qua cú pháp `@{/...}`.
- Xử lý dữ liệu Form: hiển thị form tạo mới (`GET /addPerson`), nhận dữ liệu POST (`POST /addPerson`), xác thực dữ liệu và chuyển hướng (`redirect:/personList`).
- Tích hợp static resources (CSS) từ `src/main/resources/static/css/style.css`.
- Đọc thông điệp cấu hình từ `application.properties` bằng `@Value`.

---

## 2. Cấu hình & Môi trường
- **Java**: 25
- **Spring Boot**: 4.1.1
- **Package name**: `com.sgu.j2ee.chapter1.project19`
- **Thư mục dự án**: `chapter1/part02_spring_boot/project19`

---

## 3. Cấu trúc thư mục

```
project19/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/wrapper/maven-wrapper.properties
└── src/
    ├── main/
    │   ├── java/com/sgu/j2ee/chapter1/project19/
    │   │   ├── Project19Application.java
    │   │   ├── controller/
    │   │   │   └── MainController.java
    │   │   ├── form/
    │   │   │   └── PersonForm.java
    │   │   └── model/
    │   │       └── Person.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/
    │       │   └── css/
    │       │       └── style.css
    │       └── templates/
    │           ├── addPerson.html
    │           ├── index.html
    │           └── personList.html
    └── test/
        └── java/com/sgu/j2ee/chapter1/project19/
            └── Project19ApplicationTests.java
```

---

## 4. Các chức năng & URL

| Đường dẫn (URL) | Method | Mô tả |
|-----------------|--------|-------|
| `http://localhost:8080/` hoặc `/index` | GET | Trang chủ chào mừng, đọc thông điệp từ `welcome.message` trong `application.properties`. |
| `http://localhost:8080/personList` | GET | Hiển thị bảng danh sách các thành viên (mặc định có Bill Gates, Steve Jobs). |
| `http://localhost:8080/addPerson` | GET | Hiển thị Form nhập thông tin thành viên mới (`firstName`, `lastName`). |
| `http://localhost:8080/addPerson` | POST | Tiếp nhận thông tin từ form. Nếu hợp lệ, thêm vào danh sách và chuyển hướng về `/personList`; nếu thiếu dữ liệu, hiển thị thông báo lỗi từ `error.message`. |

---

## 5. Hướng dẫn chạy ứng dụng

Sử dụng Maven Wrapper tại thư mục dự án:

```powershell
.\mvnw.cmd spring-boot:run
```

Sau khi ứng dụng khởi động thành công, truy cập:
- `http://localhost:8080/personList` để xem danh sách thành viên công ty.
