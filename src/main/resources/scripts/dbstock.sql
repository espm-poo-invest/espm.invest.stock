drop database dbstock;
create database dbstock;
use dbstock;

CREATE TABLE stock (
       id_stock varchar(36) NOT NULL,
       txt_name varchar(10) NOT NULL,
       s_date date NOT NULL,
       price double NOT NULL,
       PRIMARY KEY (id_stock)
);

insert into stock(id_stock, txt_name, s_date, price) values (uuid(), 'ATP1', '2002-02-02', 100.00);
select * from stock;