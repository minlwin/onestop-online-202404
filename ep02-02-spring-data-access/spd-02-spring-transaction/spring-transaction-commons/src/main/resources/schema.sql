set FOREIGN_KEY_CHECKS = 0;

drop table if exists ACCOUNT;

create table ACCOUNT (
	account_num varchar(4) primary key,
	account_name varchar(40) not null,
	phone varchar(12) not null,
	amount int not null,
	version int not null
);

drop table if exists BALANCE_HISTORY;

create table BALANCE_HISTORY (
	account_num varchar(4),
	version int not null,
	last_amount int not null,
	trx_id int,
	debit boolean not null,
	trx_amount int not null,
	remark varchar(255),
	foreign key (account_num) references ACCOUNT(account_num),
	primary key (account_num, version)
);

drop table if exists TRANSFER;

create table TRANSFER (
	id int AUTO_INCREMENT,
	account_from varchar(4) not null,
	account_to varchar(4) not null,
	amount int not null,
	status varchar(10) null default 'Initiate',
	transfer_at timestamp null default CURRENT_TIMESTAMP,
	remark varchar(255),
	primary key (id),
	foreign key (account_from) references ACCOUNT(account_num),
	foreign key (account_to) references ACCOUNT(account_num)
);

set FOREIGN_KEY_CHECKS = 1;
