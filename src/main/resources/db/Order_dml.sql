insert into orders (id, ordertype, storeid, teamid, money, orderdate) values
('orderid01', '1', 'storeid01', 'teamid01', '500000', '2020-08-05 09:00:00.000000'),
('orderid02', '2', 'storeid02', 'teamid01', '40000', '2020-08-07 09:00:00.000000'),
('orderid03', '1', 'storeid03', 'teamid01', '10000', '2020-08-05 09:00:00.000000'),
('orderid04', '2', 'storeid04', 'teamid01', '20000', '2020-08-02 09:00:00.000000'),
('orderid05', '1', 'storeid05', 'teamid01', '4000', '2020-08-08 09:00:00.000000'),
('orderid06', '2', 'storeid06', 'teamid01', '250000', '2020-08-01 09:00:00.000000');

insert into balanceinfos (bid ,cid, sid, totalmoney, remainmoney) values
('balanceid01','teamid01', 'storeid01', '1000000', '500000'),
('balanceid02','teamid01', 'storeid02', '2000000', '300000'),
('balanceid03','teamid01', 'storeid03', '400000', '10000'),
('balanceid04','teamid02', 'storeid01', '800000', '500000'),
('balanceid05','teamid03', 'storeid01', '1000000', '500000'),
('balanceid06','teamid03', 'storeid02', '1000000', '500000');
