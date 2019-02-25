create table book
(
	id bigint not null
		constraint book_pkey
			primary key,
	author varchar(40),
	title varchar(80),
	reader_id bigint
		constraint book_reader_id_fk
			references reader
)
;

alter table book owner to postgres
;

