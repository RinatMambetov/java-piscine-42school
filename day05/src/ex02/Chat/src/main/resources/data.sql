insert into chat.user (login, password) values ('talker1', 'pass1');
insert into chat.user (login, password) values ('talker2', 'pass2');
insert into chat.user (login, password) values ('talker3', 'pass3');
insert into chat.user (login, password) values ('talker4', 'pass4');
insert into chat.user (login, password) values ('talker5', 'pass5');

insert into chat.chatroom (name, owner) values ('room1', 1);
insert into chat.chatroom (name, owner) values ('room2', 2);
insert into chat.chatroom (name, owner) values ('room3', 3);
insert into chat.chatroom (name, owner) values ('room4', 4);
insert into chat.chatroom (name, owner) values ('room5', 5);

insert into chat.message (author, chatroom, text, date) values (1, 1, 'text1', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (1, 2, 'text2', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (2, 1, 'text3', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (2, 3, 'text4', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, chatroom, text, date) values (4, 4, 'text5', to_timestamp(1388534400+random()*63071999));
