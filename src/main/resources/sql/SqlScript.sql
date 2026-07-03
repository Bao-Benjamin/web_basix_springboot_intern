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
