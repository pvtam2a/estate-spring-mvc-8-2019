use spring82019;

insert into role(code,name) values('MANAGER','MANAGER');
insert into role(code,name) values('STAFF','STAFF');

insert into user(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1);
insert into user(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van b',1);
insert into user(username,password,fullname,status)
values('nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van c',1);
insert into user(username,password,fullname,status)
values('nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van d',1);

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);
INSERT INTO user_role(userid,roleid) VALUES (4,2);


INSERT INTO building (name, numberofbasement, buildingarea, district, ward, street, costrent, type, createddate, createdby) VALUES ('CMC Tower', '1', '100', 'QUAN_1', 'Đống Đa', 'Kim Mã', '500', 'TANG_TRET', '2019-11-03 23:50:16', 'system');
INSERT INTO building (name, numberofbasement, buildingarea, district, ward, street, costrent, type, createddate, createdby) VALUES ('FPT', '2', '200', 'QUAN_2', 'Kim Liên', 'Cầu Giấy', '600', 'NGUYEN_CAN', '2019-11-03 23:50:16', 'system');
INSERT INTO building (name, numberofbasement, buildingarea, district, ward, street, costrent, type, createddate, createdby) VALUES ('TOYOTA', '3', '300', 'QUAN_3', 'Cầu Giấy', 'Lò Đúc', '700', 'NOI_THAT,TANG_TRET', '2019-11-03 23:50:16', 'system');
INSERT INTO building (name, numberofbasement, buildingarea, district, ward, street, costrent, type, createddate, createdby) VALUES ('BIGCAMERA', '4', '400', 'QUAN_4', 'Thăng Long', 'Hai Bà Trưng', '800', 'TANG_TRET', '2019-11-03 23:50:16', 'system');
