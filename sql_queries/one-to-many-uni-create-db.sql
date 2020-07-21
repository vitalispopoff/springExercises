DROP SCHEMA IF EXISTS `hb-04-one-to-many-uni`;
CREATE SCHEMA `hb-04-one-to-many-uni`;
use `hb-04-one-to-many-uni`;								-- ? 
SET FOREIGN_KEY_CHECKS = 0;									-- ? : check line 89

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` 
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
		PRIMARY KEY (`id`),
        
	`youtube_channel` varchar(128) DEFAULT NULL,
	`hobby` varchar(45) DEFAULT NULL
) 
	ENGINE=InnoDB 
    AUTO_INCREMENT=1 
    DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` 
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
		PRIMARY KEY (`id`),
        
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,

	`instructor_detail_id` int(11) DEFAULT NULL,
		KEY `FK_DETAIL_idx` (`instructor_detail_id`),
		CONSTRAINT `FK_DETAIL` 
		FOREIGN KEY (`instructor_detail_id`) 
		REFERENCES `instructor_detail` (`id`) 
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION
) 
	ENGINE=InnoDB 
    AUTO_INCREMENT=1 
    DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` 
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
		PRIMARY KEY (`id`),

	`title` varchar(128) DEFAULT NULL,
		  UNIQUE KEY `TITLE_UNIQUE` (`title`),
          
	`instructor_id` int(11) DEFAULT NULL,
		KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
		CONSTRAINT `FK_INSTRUCTOR` 
        FOREIGN KEY (`instructor_id`) 
        REFERENCES `instructor` (`id`) 
		ON DELETE NO ACTION 
        ON UPDATE NO ACTION
) 
	ENGINE=InnoDB 
    AUTO_INCREMENT=10 
    DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` 
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
		PRIMARY KEY (`id`),

	`comment` varchar(256) DEFAULT NULL,
  
	`course_id` int(11) DEFAULT NULL,
		KEY `FK_COURSE_ID_idx` (`course_id`),
		CONSTRAINT `FK_COURSE` 
		FOREIGN KEY (`course_id`) 
		REFERENCES `course` (`id`) 
		ON DELETE NO ACTION 
        ON UPDATE NO ACTION
) 
	ENGINE=InnoDB 
    AUTO_INCREMENT=1 
    DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
