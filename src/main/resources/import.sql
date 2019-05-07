INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (1, 'Brice', 'Argenson', 'bargenson@edgenda.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (2, 'Gregoire', 'Weber', 'gweber@cleverage.com');
INSERT INTO GUEST(ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (3, 'John', 'Doe', 'jdoe@bnc.com');

INSERT INTO EVENT(ID, NAME, DESCRIPTION) VALUES (1, 'DevOps Training', 'Training for NBC about DevOps principles and tools. ');

INSERT INTO GUEST_EVENT(GUEST_ID, EVENT_ID) VALUES (1, 1);