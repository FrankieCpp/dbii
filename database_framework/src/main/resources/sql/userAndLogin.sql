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
-- DROP TABLE utenti;
-- DROP TYPE utente;
-- DROP TABLE USER_LOGGINGS;
-- DROP TYPE USER_LOGGING;
CREATE TYPE Utente AS OBJECT(
	userid varchar2(32),
	password varchar2(64),
	sessionKey varchar2(64),
    CONSTRUCTOR FUNCTION Utente(SELF IN OUT NOCOPY Utente, 
    							userid VARCHAR2, 
                               	password VARCHAR2,
                               	sessionKey VARCHAR2) RETURN SELF AS RESULT,
    CONSTRUCTOR FUNCTION Utente(SELF IN OUT NOCOPY Utente, 
    							userid VARCHAR2, 
                               	password VARCHAR2) RETURN SELF AS RESULT
        
) NOT FINAL;
/
CREATE TYPE BODY Utente AS
    CONSTRUCTOR FUNCTION Utente(SELF IN OUT NOCOPY Utente, 
    							userid VARCHAR2, 
                               	password VARCHAR2,
                               	sessionKey VARCHAR2) RETURN SELF AS RESULT IS
    BEGIN
        SELF.userid := userid;
        SELF.password := password;
        SELF.sessionKey := 'start';
        RETURN;
    END;
    CONSTRUCTOR FUNCTION Utente(SELF IN OUT NOCOPY Utente, 
    							userid VARCHAR2, 
                               	password VARCHAR2) RETURN SELF AS RESULT IS
    BEGIN
        SELF.userid := userid;
        SELF.password := password;
        SELF.password := 'start';
        RETURN;
    END;
END;
/
CREATE TABLE Utenti OF Utente;
/
ALTER TABLE Utenti
ADD CONSTRAINT user_primary_key PRIMARY KEY (userid);
/
CREATE TYPE USER_LOGGING AS OBJECT(
	userid varchar2(32),
	login timestamp, 
    CONSTRUCTOR FUNCTION USER_LOGGING(SELF IN OUT NOCOPY USER_LOGGING, 
    							userid VARCHAR2) RETURN SELF AS RESULT
);
/
CREATE TYPE BODY USER_LOGGING AS
    CONSTRUCTOR FUNCTION USER_LOGGING(SELF IN OUT NOCOPY USER_LOGGING, 
    							userid VARCHAR2) RETURN SELF AS RESULT IS
    BEGIN
        SELF.userid := userid;
        SELF.login := CURRENT_TIMESTAMP;
        RETURN;
    END;
END;
/
CREATE TABLE USER_LOGGINGS OF USER_LOGGING;
/

CREATE OR REPLACE TRIGGER ADD_USER_LOG 
AFTER UPDATE OF SESSIONKEY ON UTENTI
FOR EACH ROW
BEGIN 
	insert into USER_LOGGINGS values(USER_LOGGING(:old.userid));
END;