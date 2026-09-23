# Project 1.4: Spring @PropertySource & @Value Example

Dự án mẫu minh họa cách đọc tập tin cấu hình ngoại vi (`.properties`) trong Java & Spring Boot, tránh việc ghi cứng giá trị cấu hình (hard-coded) trong mã nguồn, dựa trên bài hướng dẫn [JavaGuides - Spring @PropertySource Annotation with Example](https://www.javaguides.net/2018/09/spring-propertysource-annotation-with-example.html).

---

## 1. Mục tiêu bài học
- Sử dụng annotation `@PropertySource` trên class `@Configuration` để chỉ định tập tin cấu hình cần nạp (`classpath:config.properties`).
- Tiêm (inject) các giá trị cấu hình vào biến bằng `@Value("${key}")`.
- Truy xuất linh hoạt các thuộc tính thông qua `org.springframework.core.env.Environment` (`env.getProperty("key")`).
- Đóng gói dữ liệu cấu hình vào đối tượng POJO (`DataSourceConfig`).

---

## 2. Cấu hình & Môi trường
- **Java**: 25
- **Spring Boot**: 4.1.1
- **Package name**: `com.sgu.j2ee.chapter1.project14`
- **Thư mục dự án**: `chapter1/part01_spring_framework/project14`

---

## 3. Cấu trúc thư mục

```
project14/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/wrapper/maven-wrapper.properties
└── src/
    ├── main/
    │   ├── java/com/sgu/j2ee/chapter1/project14/
    │   │   ├── Project14Application.java
    │   │   ├── config/
    │   │   │   └── PropertySourceDemo.java
    │   │   └── model/
    │   │       └── DataSourceConfig.java
    │   └── resources/
    │       ├── application.properties
    │       └── config.properties
    └── test/
        └── java/com/sgu/j2ee/chapter1/project14/
            └── Project14ApplicationTests.java
```

---

## 4. Các thành phần chính

### `config.properties`
Chứa các thông tin kết nối cơ sở dữ liệu:
```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/dev_db
jdbc.username=root
jdbc.password=root
```

### `DataSourceConfig.java`
Lớp mô hình (POJO) chứa các thuộc tính: `driver`, `url`, `username`, `password` cùng các hàm getter/setter và `toString()`.

### `PropertySourceDemo.java`
- Khai báo `@PropertySource("classpath:config.properties")`.
- Sử dụng `@Value` để gán giá trị tự động:
  ```java
  @Value("${jdbc.driver}")
  private String driver;
  ```
- Sử dụng `Environment` để lấy thuộc tính theo phương thức lập trình:
  ```java
  config.setDriver(env.getProperty("jdbc.driver"));
  ```
- Thực thi khi bean được khởi tạo thông qua `InitializingBean` (`afterPropertiesSet()`).

---

## 5. Kết quả khi khởi chạy

Khi ứng dụng chạy, các giá trị cấu hình được đọc từ `config.properties` và hiển thị ra màn hình console:

```text
Values injected via @Value:
Driver: com.mysql.cj.jdbc.Driver
URL: jdbc:mysql://localhost:3306/dev_db
Username: root
Password: root
Reading values via Spring Environment:
DataSourceConfig instance created: DataSourceConfig [driver=com.mysql.cj.jdbc.Driver, url=jdbc:mysql://localhost:3306/dev_db, username=root]
```
