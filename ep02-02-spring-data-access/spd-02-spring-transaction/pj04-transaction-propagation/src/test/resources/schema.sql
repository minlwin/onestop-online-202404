drop table if exists BEFORE_TBL;
drop table if exists BASE_START_TBL;
drop table if exists BASE_END_TBL;
drop table if exists AFTER_TBL;

create table BEFORE_TBL (
	id int AUTO_INCREMENT,
	message varchar(255),
	primary key (id)
);

create table BASE_START_TBL (
	id int,
	message varchar(255) not null,
	primary key (id)
);

create table BASE_END_TBL (
	id int,
	message varchar(255) not null,
	primary key (id)
);

create table AFTER_TBL (
	id int,
	message varchar(255) not null,
	primary key (id)
);