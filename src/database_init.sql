-- Drop the supermarket database if exists then re-create it

DROP DATABASE IF EXISTS `supermarket`;
CREATE DATABASE IF NOT EXISTS `supermarket`;
USE `supermarket`;

-- Create the item table inside of the supermarket database

DROP TABLE IF EXISTS item;
CREATE TABLE IF NOT EXISTS `item` (
  `barcode` varchar(30),
  `name` varchar(30) not null,
  `quantity` int DEFAULT 0 not null,
  `price` int not null,
  PRIMARY KEY (`barcode`)
);

