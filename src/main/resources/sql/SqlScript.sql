CREATE DATABASE plant_management;
use plant_management;
create table plant (
    id int auto_increment primary key,
    name varchar(50),
    price decimal(12,2),
    plant_date date ,
    img text,
    quantity int,
    description text,
    created_at timestamp default current_timestamp,
    category_id int ,
	CONSTRAINT fk_plant_category 
    FOREIGN KEY (category_id) 
    REFERENCES category(id) 
    ON DELETE cascade
    );

create table category(
    id int auto_increment primary key,
    name varchar(50)
);


DROP TABLE IF EXISTS plant;
INSERT INTO plant (name, price, plant_date, img, quantity, description, category_id) VALUES
(
    'Cây Kim Tiền', 
    150000.00, 
    '2026-01-15', 
    'https://example.com/images/kim-tien.jpg', 
    20, 
    'Cây mang lại tài lộc, dễ chăm sóc, thích hợp để bàn làm việc.', 
    1
),
(
    'Cây Hoa Hồng Leo', 
    320000.00, 
    '2026-02-20', 
    'https://example.com/images/hoa-hong-leo.jpg', 
    15, 
    'Hoa màu hồng phấn, hương thơm dịu, thích hợp trồng ban công hoặc cổng nhà.', 
    2
),
(
    'Cây Trầu Bà Thủy Sinh', 
    850000.00, 
    '2026-03-01', 
    'https://example.com/images/trau-ba.jpg', 
    50, 
    'Lọc không khí tốt, phát triển mạnh trong môi trường nước.', 
    3
),
(
    'Sen Đá Phật Bà', 
    450000.00, 
    '2026-03-10', 
    'https://example.com/images/sen-da.jpg', 
    100, 
    'Nhỏ gọn, các lá xếp tầng như tòa sen, cần nhiều ánh sáng.', 
    3
),
(
    'Cây Chanh Tứ Quý', 
    250000.00, 
    '2026-04-05', 
    'https://example.com/images/chanh-tu-quy.jpg', 
    10, 
    'Cây giống chiết cành, cho trái quanh năm, thích hợp trồng chậu lớn.', 
    1
);
INSERT INTO plant (name, price, plant_date, img, quantity, description, category_id) VALUES
(
    'Cây Mới Thêm', 
    150000.00, 
    '2026-01-15', 
    'https://example.com/images/kim-tien.jpg', 
    20, 
    'Cây mang lại tài lộc, dễ chăm sóc, thích hợp để bàn làm việc.', 
    1
);
DROP TABLE IF EXISTS plant_cate;
SET SQL_SAFE_UPDATES = 0; -- Tắt chế độ an toàn

DELETE FROM plant WHERE name IS NULL;

SET SQL_SAFE_UPDATES = 1; -- Bật lại chế độ an toàn để bảo vệ DB sau khi xóa xong
