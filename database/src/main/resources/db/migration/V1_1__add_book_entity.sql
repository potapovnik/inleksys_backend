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

insert into reader(login, password) values ('inleksys',123456);
insert into reader(login, password) values ('Vanya',1);
insert into reader(login, password) values ('Petya',1);
insert into book(id, author, title, reader_id) values(10,'Лев Толстой','Анна Каренина',1);
insert into book(id, author, title, reader_id) values(42,'Дуглас Адамс','Автостопом по галактике',null );
insert into book(id, author, title, reader_id) values(3,'Льюис Кэрролл','Алиса в стране чудес',2);
insert into book(id, author, title, reader_id) values(4,'Пауло Коэльо','Алхимик',3);
insert into book(id, author, title, reader_id) values(451,'Рей Брэдбери','451 градус по Фаренгейту',1);
insert into book(id, author, title, reader_id) values(123,'Жаклин Уилсон','Двойняшки',null );
insert into book(id, author, title, reader_id) values(17,'Фредерик Форсайт','День шакала',2);
insert into book(id, author, title, reader_id) values(189,'Салман Рушди','День шакала',3);
insert into book(id, author, title, reader_id) values(18,'Джон Уиндем','День триффидов',2);
insert into book(id, author, title, reader_id) values(20,' Роальд Даль','Дэнни — чемпион мира',2);
insert into book(id, author, title, reader_id) values(2,' ','Джейн Эйр',null );

