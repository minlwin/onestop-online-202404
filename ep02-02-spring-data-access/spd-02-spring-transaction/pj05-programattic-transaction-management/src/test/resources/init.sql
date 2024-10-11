set FOREIGN_KEY_CHECKS = 0;

truncate table TRANSFER_LOG;
truncate table BALANCE_HISTORY;
truncate table TRANSACTION_TRANSFER;
truncate table ACCOUNT;

insert into ACCOUNT values ('C001', 'Aung Aung', 100000);
insert into ACCOUNT values ('C002', 'Nilar', 300000);

set FOREIGN_KEY_CHECKS = 1;
