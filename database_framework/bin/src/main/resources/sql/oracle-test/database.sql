drop table azienda;
create table azienda(
	az_id number,
	nome varchar(20),
	primary key(az_id)
);

insert into azienda(az_id,nome) values(1,'Reply');

commit;
