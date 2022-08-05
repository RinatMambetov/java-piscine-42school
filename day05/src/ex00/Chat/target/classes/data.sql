INSERT INTO chat.users (login, password)
 VALUES ('talker1', 'pass1');
INSERT INTO chat.users (login, password)
 VALUES ('talker2', 'pass2');
INSERT INTO chat.users (login, password)
 VALUES ('talker3', 'pass3');
INSERT INTO chat.users (login, password)
 VALUES ('talker4', 'pass4');
INSERT INTO chat.users (login, password)
 VALUES ('talker5', 'pass5');

INSERT INTO chat.rooms (name, owner)
 VALUES ('room1', 1);
INSERT INTO chat.rooms (name, owner)
 VALUES ('room2', 2);
INSERT INTO chat.rooms (name, owner)
 VALUES ('room3', 3);
INSERT INTO chat.rooms (name, owner)
 VALUES ('room4', 4);
INSERT INTO chat.rooms (name, owner)
 VALUES ('room5', 5);

INSERT INTO chat.messages (author, room, text, timestamp)
 VALUES (1, 1, 'text1', '2022-01-01 00:00:01');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (2, 1, 'text2', '2022-01-02 00:00:02');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (3, 1, 'text3', '2022-01-03 00:00:03');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (4, 1, 'text4', '2022-01-04 00:00:04');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 1, 'text5', '2022-01-05 00:00:05');
