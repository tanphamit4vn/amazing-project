CREATE DATABASE Assignment

USE Assignment

DROP TABLE ACCOUNT

CREATE TABLE ACCOUNT(
	userName varchar(100),
	pass varchar(100),
	[roles] varchar(100),
	[fullName] varchar(100), 
	[age] int, 
	[gender] varchar(100), 
	[phoneNumber] varchar(100)
)

INSERT INTO ACCOUNT VALUES ('user1','1','admin','Nguyen Thai Giang',24,'Nam','0123456789')
INSERT INTO ACCOUNT VALUES ('user2','1','clerk','Nguyen Nam',22,'Nam','0213456987')
INSERT INTO ACCOUNT VALUES ('user3','1','clerk','Huynh Tu',20,'Nu','0384758369')
INSERT INTO ACCOUNT VALUES ('user4','1','customer','Tran B',29,'Nam','0983456789')
INSERT INTO ACCOUNT VALUES ('user5','1','customer','Tran C',32,'Nam','0983456789')
INSERT INTO ACCOUNT VALUES ('user6','1','customer','Tran D',45,'Nam','0983456789')
INSERT INTO ACCOUNT VALUES ('user7','1','customer','Tran E',57,'Nam','0983456789')
INSERT INTO ACCOUNT VALUES ('user8','1','customer','Thi X',28,'Nu','0983456789')
INSERT INTO ACCOUNT VALUES ('user9','1','customer','Thi Y',44,'Nu','0983456789')

SELECT * FROM ACCOUNT


 
DROP TABLE HOTELROOMS


CREATE TABLE HOTELROOMS(
	roomId int,
	statusRoom varchar(100),
	userBooked varchar(100),
	dateIn varchar(100),
	dateOut varchar(100)
)

INSERT INTO HOTELROOMS VALUES (101,'booked','user4','08/08/2021','12/08/2021')
INSERT INTO HOTELROOMS VALUES (102,'booked','user4','09/08/2021','13/08/2021')
INSERT INTO HOTELROOMS VALUES (103,'booked','user5','10/08/2021','14/08/2021')
INSERT INTO HOTELROOMS VALUES (104,'booked','user6','11/08/2021','15/08/2021')
INSERT INTO HOTELROOMS VALUES (105,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (201,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (202,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (203,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (204,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (205,'booked','user7','10/08/2021','14/08/2021')
INSERT INTO HOTELROOMS VALUES (301,'booked','user8','10/08/2021','14/08/2021')
INSERT INTO HOTELROOMS VALUES (302,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (303,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (304,'empty','empty','empty','empty')
INSERT INTO HOTELROOMS VALUES (305,'empty','empty','empty','empty')

SELECT * FROM HOTELROOMS