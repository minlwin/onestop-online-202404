insert into ACCOUNT values ('0001', 'Thidar', '0911112222', 300000, 1);
insert into ACCOUNT values ('0002', 'Nilar', '0922223333', 200000, 1);

insert into BALANCE_HISTORY (account_num, version, last_amount, debit, trx_amount, remark) values ('0001', 1, 0, true, 300000, 'Initialized');
insert into BALANCE_HISTORY (account_num, version, last_amount, debit, trx_amount, remark) values ('0002', 1, 0, true, 200000, 'Initialized');
