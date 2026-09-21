# Project113 — Personal CV Website

Ứng dụng CV cá nhân một trang dùng HTML, CSS, JavaScript và được đặt trong Spring Boot static resources.

## Chạy local bằng Spring Boot

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Mở: `http://localhost:8080`

## Nội dung cần sửa

- `src/main/resources/static/index.html`: họ tên, mô tả, học vấn, kỹ năng, dự án, liên hệ.
- `src/main/resources/static/images/avatar-placeholder.svg`: thay bằng ảnh thật, ví dụ `avatar.jpg`, rồi sửa `src` trong `index.html`.
- `src/main/resources/static/css/style.css`: màu sắc và giao diện.

## Deploy GitHub Pages

Workflow `.github/workflows/pages.yml` publish trực tiếp thư mục `src/main/resources/static`.

1. Push repository lên GitHub, branch `main`.
2. Vào **Settings → Pages**.
3. Chọn **Source: GitHub Actions**.
4. Mỗi lần push lên `main`, workflow sẽ deploy lại website.

> Không đưa số điện thoại, địa chỉ hoặc dữ liệu riêng tư lên repository public nếu bạn không muốn công khai chúng.
