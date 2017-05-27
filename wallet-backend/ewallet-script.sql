DROP DATABASE IF EXISTS `ewallet`;
CREATE DATABASE `ewallet`;

DROP TABLE IF EXISTS `ewallet`.`users`;
CREATE TABLE  `ewallet`.`users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `role` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique` (`username`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='Wallets Members';


DROP TABLE IF EXISTS `ewallet`.`credit_cards`;
CREATE TABLE  `ewallet`.`credit_cards` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `card_number` varchar(16) NOT NULL DEFAULT '',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `name_holder` varchar(255) NOT NULL DEFAULT '',
  `month_exp` smallint(5) unsigned NOT NULL DEFAULT '0',
  `year_exp` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_credit_cards_users` (`user_id`),
  CONSTRAINT `FK_credit_cards_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Credit Card of Members';
