create table reader
(
	id serial not null
		constraint reader_pkey
			primary key,
	login varchar(40) not null,
	password varchar(300) not null
)
;

alter table reader owner to postgres;

create unique index reader_login_uindex
	on reader (login);
