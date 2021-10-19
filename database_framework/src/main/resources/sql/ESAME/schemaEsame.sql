CREATE OR REPLACE TYPE SocioType AS OBJECT(
  codiceFiscale varchar2(16)
) NOT FINAL;
/
CREATE OR REPLACE TYPE ImbarcazioneType AS OBJECT(
  matricola varchar2(10),
  modello ref ModelloType,
  socio ref SocioType
) NOT FINAL;
/
CREATE OR REPLACE TYPE ModelloType AS OBJECT(
  codice varchar2(10),
  stazza numeric(10,2) ,
  lunghezza numeric(10,2) ,
  pescaggio numeric(10,2) 
) NOT FINAL;
/
CREATE OR REPLACE TYPE TestImbarcazioneType AS OBJECT(
  codice varchar2(10),
  nome varchar2(32),
  punteggioMassimo numeric(3),
  CONSTRUCTOR FUNCTION TestImbarcazioneType(SELF IN OUT NOCOPY TestImbarcazioneType, 
    codice VARCHAR2, 
    nome VARCHAR2,
    punteggioMaggimo numeric) RETURN SELF AS RESULT,
  CONSTRUCTOR FUNCTION TestImbarcazioneType(SELF IN OUT NOCOPY TestImbarcazioneType, 
    codice VARCHAR2, 
    nome VARCHAR2) RETURN SELF AS RESULT
) NOT FINAL;
/
CREATE TYPE BODY TestImbarcazioneType AS
    CONSTRUCTOR FUNCTION TestImbarcazioneType(SELF IN OUT NOCOPY TestImbarcazioneType, 
      codice VARCHAR2, 
      nome VARCHAR2,
      punteggioMaggimo numeric) RETURN SELF AS RESULT IS
    BEGIN
        SELF.codice := codice;
        SELF.nome := nome;
        SELF.punteggioMassimo := punteggioMassimo;
        RETURN;
    END;
    CONSTRUCTOR FUNCTION TestImbarcazioneType(SELF IN OUT NOCOPY TestImbarcazioneType, 
      codice VARCHAR2, 
      nome VARCHAR2) RETURN SELF AS RESULT IS
    BEGIN
        SELF.codice := codice;
        SELF.nome := nome;
        SELF.punteggioMassimo := 100;
        RETURN;
    END;
END;
/
CREATE OR REPLACE TYPE DipendenteType AS OBJECT(
  codiceFiscale varchar2(16),
  cognome varchar2(32),
  nome varchar2(32),
  indirizzo varchar2(100),
  telefono varchar2(10)
) NOT INSTANTIABLE NOT FINAL;
/
CREATE OR REPLACE TYPE TecnicoType UNDER DipendenteType (
  salario numeric(10,2)
) NOT FINAL;
/
CREATE OR REPLACE TYPE PersonaleMarittimoType UNDER DipendenteType (
  dataUltimaVisita timestamp,
  flgCapitano char(1)
) NOT FINAL;
/
CREATE OR REPLACE TYPE ComandabileDaType AS OBJECT (
  capitano varchar2(16),
  modello varchar2(10)
) NOT FINAL;
/
CREATE OR REPLACE TYPE EspertoInType AS OBJECT (
  tecnico varchar2(16),
  modello varchar2(10) 
) NOT FINAL;
/
CREATE OR REPLACE TYPE TestEseguitiType AS OBJECT (
  ident varchar2(1000),
  nomeTest varchar2(10),
  imbarcazione varchar2(10),
  tecnico varchar2(16),
  dataDiEsecuzione timestamp,
  tempoDiEsecuzione interval day(0) to second,
  punteggio numeric(3)
) NOT FINAL;
/

CREATE TABLE Socio OF SocioType(
  primary key(codiceFiscale)
);
/
CREATE TABLE Modello OF ModelloType(
  primary key(codice)
);
/
CREATE TABLE Imbarcazione OF ImbarcazioneType(
  primary key(matricola)
);
/
CREATE TABLE TestImbarcazione OF TestImbarcazioneType(
  primary key(codice)
);
/
CREATE TABLE Tecnico OF TecnicoType(
  primary key(codiceFiscale)
);
/
CREATE TABLE PersonaleMarittimo OF PersonaleMarittimoType(
  primary key(codiceFiscale)
);
/
CREATE TABLE ComandabileDa OF ComandabileDaType(
  primary key(capitano,modello),
  CONSTRAINT fk_cap  FOREIGN KEY (capitano) REFERENCES personalemarittimo(codicefiscale)
  ON DELETE CASCADE,
  CONSTRAINT fk_mod FOREIGN KEY (modello) REFERENCES modello(codice)
  ON DELETE CASCADE
);
/
CREATE TABLE EspertoIn OF EspertoInType(
  primary key(modello,tecnico)
);
/
create table testeseguiti of TestEseguitiType(
  primary key(ident),
  CONSTRAINT fk_column  FOREIGN KEY (nomeTest) REFERENCES TestImbarcazione(codice)
    ON DELETE CASCADE,
  CONSTRAINT fk_column2 FOREIGN KEY (imbarcazione) REFERENCES imbarcazione(matricola)  
  ON DELETE CASCADE,
  CONSTRAINT fk_column3 FOREIGN KEY (tecnico) REFERENCES tecnico(codicefiscale)    
	ON DELETE CASCADE
  );
/
CREATE SEQUENCE testeseguti_sequence
start with 1
increment by 1
minvalue 1
maxvalue 1000000;
/
create or replace
trigger checkvalore_test
before insert on testEseguiti
for each row
declare 
  valoreFinale TestImbarcazione.punteggioMassimo%type := 0;
  codiceTest TestImbarcazione.codice%type := '';
  cursor cc is select punteggioMassimo from TestImbarcazione where codice = codiceTest;
begin
  codiceTest := :new.nomeTest;
  open cc;
  fetch cc into valoreFinale; 
  if cc%FOUND THEN
    if valoreFinale < :new.punteggio then
      raise_application_error(-20005, 'invalid value');
    end if;
  ELSE
      raise_application_error(-20005, 'test not found');
  END IF;
  close cc;
end;
/
create or replace trigger checkcapitano
before insert on comandabileda
for each row
declare 
  ecapitano PersonaleMarittimo.flgcapitano%type := 'N';
  membro PersonaleMarittimo.codicefiscale%type := '';
  cursor dd is select flgcapitano from personalemarittimo where codicefiscale = membro;
begin
  membro := :new.capitano;
  open dd;
  fetch dd into ecapitano; 
  if dd%FOUND THEN
    if ecapitano != 'S' then
      raise_application_error(-20005, 'invalid value');
    end if;
  ELSE
      raise_application_error(-20005, 'test not found');
  END IF;
  close dd;
end;