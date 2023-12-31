create database JO;

USE JO;

CREATE TABLE CLIENTS(
	IDCLIENT int NOT NULL auto_increment,
    MAILCLIENT VARCHAR(100),
    NOMCLIENT VARCHAR(100),
    MDPCLIENT VARCHAR(100),
	primary key(IDCLIENT)
);

INSERT INTO CLIENTS(MAILCLIENT, NOMCLIENT, MDPCLIENT) VALUES('mail.admin@gmail.com', 'admin', 'admin');

CREATE TABLE CONCOURS(
	PARTICIP boolean not null,
    GAGNANT boolean not null default false,
    IDCLIENT int NOT NULL auto_increment,
    FOREIGN KEY(IDCLIENT)
    REFERENCES CLIENTS(IDCLIENT),
	primary key(IDCLIENT)
);

INSERT INTO CONCOURS(PARTICIP, IDCLIENT) VALUES(true, (SELECT IDCLIENT FROM CLIENTS WHERE NOMCLIENT = 'admin'));

SELECT * FROM CLIENTS;

SELECT * FROM CONCOURS;

ALTER TABLE CONCOURS
MODIFY PARTICIP boolean not null default false;

UPDATE CONCOURS
SET
	PARTICIP = false,
    GAGNANT = false
WHERE TRUE;