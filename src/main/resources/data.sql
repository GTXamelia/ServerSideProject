insert into shipping_company (scid, balance, home_port, name) values (900, 20000000, "Cork Harbour", "P&O");
insert into shipping_company (scid, balance, home_port, name) values (901, 97000000, "Portsmouth", "Cunard Line");
insert into shipping_company (scid, balance, home_port, name) values (902, 97000000, "Rotterdam", "Maersk");
insert into shipping_company (scid, balance, home_port, name) values (903, 107000000, "Miami", "Royal Caribbean");
insert into shipping_company (scid, balance, home_port, name) values (904, 142200000000, "Boston Harbor", "U.S. Navy");
insert into shipping_company (scid, balance, home_port, name) values (905, 18400000000, "Cape Canaveral Air Force Station", "NASA");

insert into ship (sid, cost, name, passengers, metres, scid) values (100, 302718, "USS Constitution", 450, 93, 904);
insert into ship (sid, cost, name, passengers, metres, scid) values (101, 5000000, "Titanic", 1253, 269, 901);
insert into ship (sid, cost, name, passengers, metres, scid) values (102, 4000000, "Olympic", 952, 269, 901);
insert into ship (sid, cost, name, passengers, metres, scid) values (103, 9500000, "Star of the Sea", 2952, 404, 900);
insert into ship (sid, cost, name, passengers, metres, scid) values (104, 6333000, "Oceans 11", 4552, 702, 903);
insert into ship (sid, cost, name, passengers, metres, scid) values (105, 6333000, "Mary Celeste", 0, 202, NULL);

insert into order_info (oid, scid, sid, date) values (500, 904, 100, "1794-03-01");
insert into order_info (oid, scid, sid, date) values (501, 901, 101, "1912-01-01");
insert into order_info (oid, scid, sid, date) values (502, 901, 102, "1908-07-12");
insert into order_info (oid, scid, sid, date) values (503, 900, 103, "2011-12-01");
insert into order_info (oid, scid, sid, date) values (504, 903, 104, "2016-03-07");
