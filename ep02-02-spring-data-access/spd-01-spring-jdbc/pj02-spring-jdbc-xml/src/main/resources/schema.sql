create table ACCOUNT (
	id int GENERATED BY DEFAULT AS IDENTITY,
	name varchar(40) not null,
	phone varchar(12) not null
);
