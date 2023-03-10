INSERT INTO user_tble (id,username, password,email_id,role) VALUES (101,'susmithas1', 'susmithas1','susmithas1@gmail.com','SALES');
INSERT INTO user_tble (id,username, password,email_id,role) VALUES (102,'sampath', 'sampath','sampath@gmail.com','APPROVER');
INSERT INTO user_tble (id,username, password,email_id,role) VALUES (103,'ruchira', 'ruchira','ruchira@gmail.com','DEALER');
INSERT INTO user_tble (id,username, password,email_id,role) VALUES (104,'opsteam', 'opsteam','opsteam@gmail.com','OPS');
INSERT INTO user_tble (id,username, password,email_id,role) VALUES (105,'admin', 'admin','admin@gmail.com','ADMIN');























-- user for authentication
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (101,'sumitp1', 'p1','sumit@gmail.com','CEO');
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (102,'alice', 'alice','alice@gmail.com','CEO');
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (103,'carol', 'carol','alice@gmail.com','DEV');
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (104,'david', 'david','alice@gmail.com','DEV');
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (105,'bob', 'bob','alice@gmail.com','CTO');
--INSERT INTO user_tble (id,username, password,email_id,role) VALUES (106,'john', 'john','alice@gmail.com','HR');

-- salaries
INSERT INTO salary (username, amount) VALUES ('alice', 1000);
INSERT INTO salary (username, amount) VALUES ('sumitp1', 1000);
INSERT INTO salary (username, amount) VALUES ('bob', 800);
INSERT INTO salary (username, amount) VALUES ('carol', 600);
INSERT INTO salary (username, amount) VALUES ('david', 500);
INSERT INTO salary (username, amount) VALUES ('john', 900);

-- documents
INSERT INTO document (content, owner) VALUES ('Alice Document 1', 'alice');
INSERT INTO document (content, owner) VALUES ('Bob Document 1', 'bob');
INSERT INTO document (content, owner) VALUES ('Bob Document 2', 'bob');
INSERT INTO document (content, owner) VALUES ('David Document 1', 'david');
INSERT INTO document (content, owner) VALUES ('David Document 2', 'david');
INSERT INTO document (content, owner) VALUES ('Carol Document 1', 'carol');
INSERT INTO document (content, owner) VALUES ('John Document 1', 'john');