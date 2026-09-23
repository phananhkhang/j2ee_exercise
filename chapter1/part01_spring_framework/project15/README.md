# Project 1.5: Spring @Autowired & @Qualifier Example

Dự án mẫu minh họa tính năng Dependency Injection (DI) trong Spring Boot thông qua các annotation `@Autowired` và `@Qualifier`, dựa trên bài viết [JavaGuides - Spring @Autowired Annotation Example](https://www.javaguides.net/2018/09/spring-autowired-annotation-with-example.html).

---

## 1. Mục tiêu bài học
- Hiểu và áp dụng cơ chế tự động tiêm phụ thuộc (Dependency Injection) bằng `@Autowired`.
- Phân biệt và thực hành 3 kỹ thuật tiêm phụ thuộc trong Spring:
  1. **Constructor Injection** (Khuyến nghị sử dụng bởi Spring team).
  2. **Setter Injection**.
  3. **Field Injection**.
- Sử dụng `@Qualifier` để chỉ định chính xác bean cần tiêm khi có nhiều bean cùng hiện thực (implement) một interface chung (`NoUniqueBeanDefinitionException`).

---

## 2. Cấu hình & Môi trường
- **Java**: 25
- **Spring Boot**: 4.1.1
- **Package name**: `com.sgu.j2ee.chapter1.project15`
- **Thư mục dự án**: `chapter1/part01_spring_framework/project15`

---

## 3. Cấu trúc thư mục

```
project15/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/wrapper/maven-wrapper.properties
└── src/
    ├── main/
    │   ├── java/com/sgu/j2ee/chapter1/project15/
    │   │   ├── Project15Application.java
    │   │   ├── controller/
    │   │   │   └── PizzaController.java
    │   │   └── service/
    │   │       ├── Pizza.java
    │   │       ├── VegPizza.java
    │   │       └── NonVegPizza.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/sgu/j2ee/chapter1/project15/
            └── Project15ApplicationTests.java
```

---

## 4. Các thành phần chính

### `Pizza.java`
Interface chung định nghĩa hành vi:
```java
public interface Pizza {
    String getPizza();
}
```

### `VegPizza.java` & `NonVegPizza.java`
Hai component cùng implement interface `Pizza`:
- `VegPizza`: `@Component("vegPizza")` trả về `"Veg Pizza"`.
- `NonVegPizza`: `@Component("nonVegPizza")` trả về `"Non-veg Pizza"`.

### `PizzaController.java`
Sử dụng `@Autowired` kết hợp `@Qualifier("vegPizza")` để giải quyết sự nhập nhằng (ambiguity):
```java
@Autowired
public PizzaController(@Qualifier("vegPizza") Pizza pizza) {
    this.pizza = pizza;
}
```

---

## 5. Kết quả khi khởi chạy

Khi ứng dụng chạy, `PizzaController` được tiêm bean `VegPizza` theo đúng `@Qualifier`:

```text
inside PizzaController constructor
calling pizzaController.getPizza()
Veg Pizza
```
