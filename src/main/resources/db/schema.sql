SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS orderdb;
CREATE TABLE orderdb(
    orderdb_id int NOT NULL AUTO_INCREMENT,
    orderdb_description varchar(100) NOT NULL,
    primary key(orderdb_id)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS courierdb;
CREATE TABLE courierdb(
    courierdb_id int NOT NULL AUTO_INCREMENT,
    courierdb_orderid int NOT NULL,
    courierdb_description varchar(100) NOT NULL,
    primary key(courierdb_id),
    foreign key(courierdb_orderid) references orderdb(orderdb_id)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS operatordb;
CREATE TABLE IF NOT EXISTS operatordb(
    operatordb_id int NOT NULL AUTO_INCREMENT,
    operatordb_orderid int NOT NULL,
    operatordb_date timestamp NOT NULL,
    primary key(operatordb_id),
    foreign key(operatordb_orderid) references orderdb(orderdb_id)
) DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=1;