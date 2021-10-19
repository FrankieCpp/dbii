-- CONNECT TO SYSTEM
CREATE USER esamedatabase
PROFILE default
IDENTIFIED BY esamedatabase
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON USERS
ACCOUNT UNLOCK;
/
grant all privileges to esamedatabase identified by esamedatabase;

-- CONNECT TO DATABASE
CREATE TYPE Utente AS OBJECT(
	userid varchar2(32),
	password varchar2(64),
	sessionKey varchar2(64)
);
/
CREATE TABLE Utenti OF Utente;
/
ALTER TABLE Utenti
ADD CONSTRAINT user_primary_key PRIMARY KEY (userid);
/
