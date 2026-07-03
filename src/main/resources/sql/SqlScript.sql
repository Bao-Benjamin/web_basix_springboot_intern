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
    created_at timestamp default current_timestamp
    );

create table category(
    id int auto_increment primary key,
    name varchar(50)
);

create table plant_cate(
plant_id int, 
    category_id int,
    constraint fk_plant
    foreign key (plant_id) references plant(id) on delete cascade,
    constraint fk_category
    foreign key (category_id) references category(id) on delete cascade

) 

