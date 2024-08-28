drop table DIVISION if exists;

create table DIVISION (
	id int primary key,
	name varchar(60) not null
);

drop table DISTRICT if exists;

create table DISTRICT (
	id int primary key,
	division_id int not null,
	name varchar(60) not null,
	foreign key (division_id) references DIVISION (id)
);

drop table TOWNSHIP if exists;

create table TOWNSHIP (
	id int primary key,
	district_id int not null,
	name varchar(60) not null,
	foreign key (district_id) references DISTRICT (id)
);