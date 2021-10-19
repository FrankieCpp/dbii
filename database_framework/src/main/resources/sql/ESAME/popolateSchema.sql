INSERT INTO SOCIO VALUES('RKCMHW83T23Q174G');
INSERT INTO SOCIO VALUES('ORPAWN86X19A978F');
INSERT INTO SOCIO VALUES('XBYJRR86R12Q942I');
INSERT INTO SOCIO VALUES('ZMNWBY82Y28G665C');
INSERT INTO SOCIO VALUES('NFVLFA91Q22W981M');
INSERT INTO SOCIO VALUES('XXJDTJ85I22H991T');
INSERT INTO SOCIO VALUES('IIXATD91A22L270F');
INSERT INTO SOCIO VALUES('BFATAW85M14A851A');
INSERT INTO SOCIO VALUES('ICCSTP91J20O552Y');
INSERT INTO SOCIO VALUES('AJHVVP81S11G366V');
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('SELWNNHJWD',4.0,9.0,6.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('GEMAAXYAON',9.0,3.0,2.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('OVIWMVCAYL',3.0,4.0,8.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('QFMRXSVEZS',1.0,1.0,3.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('WESDCUXBGJ',4.0,6.0,5.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('NTOWXAUYSO',6.0,6.0,5.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('TLCNBYJVOV',5.0,9.0,3.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('AMUTSMSIAK',6.0,8.0,4.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('MONUDSHTIK',7.0,8.0,9.0);
INSERT INTO MODELLO(CODICE,STAZZA,LUNGHEZZA,PESCAGGIO) VALUES('NMOKIDKUEA',5.0,9.0,1.0);
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'EIRKLTAKXF', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='SELWNNHJWD' and p.codicefiscale='RKCMHW83T23Q174G';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'VGGVJPXIFO', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='GEMAAXYAON' and p.codicefiscale='ORPAWN86X19A978F';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'XBHNFYAHYA', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='OVIWMVCAYL' and p.codicefiscale='XBYJRR86R12Q942I';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'LSHEPDKIND', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='QFMRXSVEZS' and p.codicefiscale='ZMNWBY82Y28G665C';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'OGRUHKPWVD', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='WESDCUXBGJ' and p.codicefiscale='NFVLFA91Q22W981M';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'LXBDOIMMVH', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='NTOWXAUYSO' and p.codicefiscale='XXJDTJ85I22H991T';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'HPKVCPBBEW', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='TLCNBYJVOV' and p.codicefiscale='IIXATD91A22L270F';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'ZEJKIAYWXI', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='AMUTSMSIAK' and p.codicefiscale='BFATAW85M14A851A';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'NJSFVRYCGX', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='MONUDSHTIK' and p.codicefiscale='ICCSTP91J20O552Y';
INSERT INTO IMBARCAZIONE(MATRICOLA, SOCIO, MODELLO) SELECT 'SJRDWFOKPM', ref(p), ref(m) from Socio p, Modello m WHERE m.codice='NMOKIDKUEA' and p.codicefiscale='AJHVVP81S11G366V';
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('BIJVMY92V20G839G','Francesco','Coppi','QYJORUANVW','PJHFITZJSC',TO_DATE('1994-05-29', 'yyyy-mm-dd'),'N');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('YYQFOI97F24Y603G','Francesca','Ronco','DGNUCJQHTE','ZFDWYQTKSU',TO_DATE('1990-04-04', 'yyyy-mm-dd'),'N');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('VIVQYC97E29C145B','Domenico','Luisi','IZQYRGEKMY','RJFZGPCGWO',TO_DATE('2005-10-16', 'yyyy-mm-dd'),'N');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('PHIMFL87R29T370W','Mario','Lombardo','SGLJPTVQIC','AVDTGERUSF',TO_DATE('1990-06-21', 'yyyy-mm-dd'),'S');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('MBAUUF84Q23P701Q','Giorgio','Vanni','KRSVFFNCGM','GKPUGVOIQX',TO_DATE('2010-01-09', 'yyyy-mm-dd'),'N');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('YMDOHW82T23Z562K','Giovanni','Lombardo','PDFPACIRNR','ATFLUCXFNI',TO_DATE('1991-06-09', 'yyyy-mm-dd'),'S');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('TNACXN95C20L814A','Davide','Nicassio','TPNLIPJWCI','RGSPRSZTUC',TO_DATE('2002-05-25', 'yyyy-mm-dd'),'N');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('TAZXAX86K21H169Y','Vincenzo','Susca','RRDVGCFOQU','TZKPBDIUHN',TO_DATE('2014-02-22', 'yyyy-mm-dd'),'S');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('OFWSJV86X12Y672B','Loredana','Palmisano','ADCTDDUTBI','WSBNOBHDVW',TO_DATE('2001-08-18', 'yyyy-mm-dd'),'S');
INSERT INTO PERSONALEMARITTIMO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,DATAULTIMAVISITA,FLGCAPITANO) VALUES ('DEZYWV84C28E371E','Laura','Palazzo','YWQXVKIFLZ','EGIBHMGPDF',TO_DATE('1995-07-23', 'yyyy-mm-dd'),'S');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('EXHGNC93F25Y726N','Roberta','Rossi','EVWBZMLCVR','ZKQBFLBLYR',11875.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('EXHGNC93F25Y726N','SELWNNHJWD');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('EXHGNC93F25Y726N','SELWNNHJWD');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('DSRCBJ84N17Q122D','Laura','Palazzo','FNXYZTNHFB','ZBASBOBZSD',13371.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('DSRCBJ84N17Q122D','GEMAAXYAON');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('DSRCBJ84N17Q122D','GEMAAXYAON');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('QRUMYO87H24R249J','Loredana','Palmisano','RECHUKMFHR','AUUMTNRESO',14868.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('QRUMYO87H24R249J','OVIWMVCAYL');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('QRUMYO87H24R249J','OVIWMVCAYL');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('FAOWFL89B25Y266Q','Vincenzo','Susca','BYVNYTXMEI','AHOOYZCWNU',12067.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('FAOWFL89B25Y266Q','QFMRXSVEZS');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('FAOWFL89B25Y266Q','QFMRXSVEZS');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('WPYVCJ92E12X383E','Davide','Nicassio','WUEOOHBXXS','BRYHRGCDLA',13758.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('WPYVCJ92E12X383E','WESDCUXBGJ');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('WPYVCJ92E12X383E','WESDCUXBGJ');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('DTTOPG95G19Z873J','Giovanni','Lombardo','BELLWZPNIT','DDDOKFCLQF',11394.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('DTTOPG95G19Z873J','NTOWXAUYSO');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('DTTOPG95G19Z873J','NTOWXAUYSO');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('UXYDTI93P26F376F','Giorgio','Vanni','MEVEKJUYJE','VVYQKTOXOV',13313.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('UXYDTI93P26F376F','TLCNBYJVOV');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('UXYDTI93P26F376F','TLCNBYJVOV');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('ZBKWNG89Q26D678D','Mario','Lombardo','LIIEHHOTID','MNQQZQQHEK',14251.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('ZBKWNG89Q26D678D','AMUTSMSIAK');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('ZBKWNG89Q26D678D','AMUTSMSIAK');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('BSZZKG95C17E366E','Domenico','Luisi','SAPIRENFSP','QBDXIMYFCE',12095.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('BSZZKG95C17E366E','MONUDSHTIK');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('BSZZKG95C17E366E','MONUDSHTIK');
INSERT INTO TECNICO(CODICEFISCALE,COGNOME,NOME,INDIRIZZO,TELEFONO,SALARIO) VALUES ('BZKBSI94F13Y346N','Francesca','Ronco','SUPYWEBAKA','AEGWBIUIFB',10252.0);
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('BZKBSI94F13Y346N','NMOKIDKUEA');
INSERT INTO ESPERTOIN(TECNICO,MODELLO) VALUES ('BZKBSI94F13Y346N','NMOKIDKUEA');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('JMUYJWZGZQ',20,'AQFYMFQDAE');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('RZUGJALSSI',20,'OSRNTQMIWK');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('MGQWCDQKQD',20,'SCYDSSUBQO');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('ALDUKKJMUV',20,'JREIEQJKOZ');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('DTOJPTJGCY',20,'DUSSQXYLNR');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('TJTFIPBCLB',20,'LKFWVEWJHH');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('UZYCYPRTOJ',20,'AQRHDQBSYF');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('MYKPEQOXQY',20,'ZXZLPPBDLW');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('LYEWRQKRYH',20,'PTXCQZTKCJ');
INSERT INTO TESTIMBARCAZIONE(CODICE,PUNTEGGIOMASSIMO,NOME) VALUES ('CVLNCHULNE',20,'TQQUOHZRQI');
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'JMUYJWZGZQ','EIRKLTAKXF','EXHGNC93F25Y726N', TO_DATE('1992-11-20', 'yyyy-mm-dd'), interval '0 02:07:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'RZUGJALSSI','VGGVJPXIFO','DSRCBJ84N17Q122D', TO_DATE('2013-09-07', 'yyyy-mm-dd'), interval '0 22:37:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'MGQWCDQKQD','XBHNFYAHYA','QRUMYO87H24R249J', TO_DATE('1996-05-21', 'yyyy-mm-dd'), interval '0 22:54:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'ALDUKKJMUV','LSHEPDKIND','FAOWFL89B25Y266Q', TO_DATE('2008-11-22', 'yyyy-mm-dd'), interval '0 06:21:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'DTOJPTJGCY','OGRUHKPWVD','WPYVCJ92E12X383E', TO_DATE('2005-03-11', 'yyyy-mm-dd'), interval '0 16:06:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'TJTFIPBCLB','LXBDOIMMVH','DTTOPG95G19Z873J', TO_DATE('2015-02-28', 'yyyy-mm-dd'), interval '0 04:37:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'UZYCYPRTOJ','HPKVCPBBEW','UXYDTI93P26F376F', TO_DATE('1990-06-12', 'yyyy-mm-dd'), interval '0 16:53:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'MYKPEQOXQY','ZEJKIAYWXI','ZBKWNG89Q26D678D', TO_DATE('2016-09-08', 'yyyy-mm-dd'), interval '0 17:50:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'LYEWRQKRYH','NJSFVRYCGX','BSZZKG95C17E366E', TO_DATE('2003-07-21', 'yyyy-mm-dd'), interval '0 22:01:00' day(0) to second ,2);
INSERT INTO TESTESEGUITI(IDENT, NOMETEST, IMBARCAZIONE, TECNICO, DATADIESECUZIONE, TEMPODIESECUZIONE, PUNTEGGIO) VALUES (testeseguti_sequence.nextval, 'CVLNCHULNE','SJRDWFOKPM','BZKBSI94F13Y346N', TO_DATE('1993-03-16', 'yyyy-mm-dd'), interval '0 12:39:00' day(0) to second ,2);

INSERT INTO comandabileda(capitano, modello) VALUES('PHIMFL87R29T370W','SELWNNHJWD');
COMMIT;