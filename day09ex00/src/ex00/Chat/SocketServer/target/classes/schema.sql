create schema if not exists spring;

drop table if exists spring.users;

create table spring.users (
    id          serial primary key ,
--     username        varchar(50) unique ,
--     password    varchar(50) unique
    username    text ,
    password    text
);
