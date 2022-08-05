create schema if not exists spring;

drop table if exists spring.users;

create table spring.users (
    id          serial primary key ,
    username    text ,
    password    text
);
