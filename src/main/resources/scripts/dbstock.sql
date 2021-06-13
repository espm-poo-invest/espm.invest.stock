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

insert into stock(id_stock, txt_name, s_date, price) values
(uuid(), 'ATP1', '2002-02-02', 100.00),
(uuid(), 'AAPL', '2021-06-11', 127.35),
(uuid(), 'AAPL', '2021-06-10', 127.02),
(uuid(), 'AAPL', '2021-06-09', 127.13),
(uuid(), 'AAPL', '2021-06-08', 126.74),
(uuid(), 'AMC', '2021-06-11', 49.40),
(uuid(), 'AMC', '2021-06-10', 42.81),
(uuid(), 'AMC', '2021-06-09', 49.34),
(uuid(), 'AMC', '2021-06-08', 55.05),
(uuid(), 'AMC', '2021-06-07', 55.00);
select * from stock;