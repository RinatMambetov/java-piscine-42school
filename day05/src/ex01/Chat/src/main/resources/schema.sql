create schema if not exists chat;

drop table if exists chat.user, chat.chatroom, chat.message;

create table chat.user (
    id          serial primary key ,
    login       varchar(50) unique ,
    password    varchar(20)
);

create table chat.chatroom (
    id          serial primary key ,
    name        varchar(50) ,
    owner       int references chat.user (id)
);

create table chat.message (
    id          serial primary key ,
    author      int references chat.user (id),
    chatroom    int references chat.chatroom (id),
    text        text ,
    date        timestamp
);
