/*
 * FOREIGN KEY WITH OID
 */

-- Types
CREATE TYPE azienda as object(
	ident number(2),
	nome varchar(20)
);
 
create or replace type impiegato as object(
	ident numeric(2),
	cf varchar(16),
	nome varchar(30),
	dove ref azienda
);

-- Typed tables
create table aziende of azienda;
create table impiegati of impiegato;

-- Query
insert into aziende values(11,'reply');
insert  into aziende values (14,'microsoft');
insert into aziende values (13,'auriga');
insert into aziende values (12,'accenture');

-- per impiegato ho usato lo stesso ordine definito nel tipo;
insert into impiegati 
	select impiegato(1,'asdf','ancora',ref(p)) 
	from aziende p 
	where p.nome='reply';

commit;
