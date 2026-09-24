Dự án được tổ chức thành các package như sau:
- Tầng dùng chung:
  + Gói form: chứa các lớp hỗ trợ xử lý phần giao diện tương tác với người dùng.
  + Gói dto: chứa các lớp hỗ trợ chuyển dữ liệu giữa tầng ứng dụng và tầng dịch vụ.
- Tầng dữ liệu:
  + Gói model: chứa các lớp bean dữ liệu
  + Gói repository: chứa các lớp bean xử lý liên quan đến việc lưu trữ dữ liệu.
- Tầng dịch vụ:
  + Gói service: chứa các lớp hỗ trợ tầng ứng dụng
- Tầng ứng dụng (giao diện)
  + Gói config: chứa các cấu hình sử dụng cho ứng dụng ví dụ như cấu hình thông tin kết nối với cơ sở dữ
  liệu, thông tin kết nối với mail server, các bean mà bạn muốn khởi tạo.
  + Gói controller: chứa các lớp xử lý tương tác với người dùng trên nền tảng WEB.
  + Lớp EazyschoolApplication: ứng dụng spring boot
- Phần tài nguyên của ứng dụng
  + static.assets: chứa các tài nguyên tĩnh của dự án như các tập tin css, image, …
  + templates: chứa các trang thymeleaf, các trang giúp tạo ra giao diện cho ứng dụng web.
- Thông tin khác: dự án có sử dụng Lombok