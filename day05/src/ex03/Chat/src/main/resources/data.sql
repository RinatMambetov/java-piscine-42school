insert into chat.user (id, login, password) values (default, 'Mark', '123123');
insert into chat.user (login, password) values ('Ben', '456456');
insert into chat.user (login, password) values ('Rob', '789789');
insert into chat.user (login, password) values ('Jack', '147147');
insert into chat.user (login, password) values ('Sam', '258258');

insert into chat.chatroom (name, owner) values ('chat1', 1);
insert into chat.chatroom (name, owner) values ('chat2', 2);
insert into chat.chatroom (name, owner) values ('chat3', 1);
insert into chat.chatroom (name, owner) values ('chat4', 2);
insert into chat.chatroom (name, owner) values ('chat5', 3);

insert into chat.message (author, chatroom, text, date) values (1, 1, 'qwert', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (1, 2, 'asdfg', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (2, 1, 'zxcvb', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (2, 3, 'poiuy', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (4, 4, 'lkjhg', to_timestamp(1388534400+random()*63071999));
