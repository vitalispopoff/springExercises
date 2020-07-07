drop SCHEMA IF EXISTS `hb-03-one-to-many`;	# deleting the schema
CREATE SCHEMA `hb-03-one-to-many`;			# reconstructing the schema
use `hb-03-one-to-many`;

SET FOREIGN_KEY_CHECKS = 0; 				# what's a foreign_key_checks

DROP TABLE IF EXISTS `instructor_detail`;	# deleting the instructor_detail table
CREATE TABLE `instructor_detail` (
	`id` 				int(11) 		NOT NULL AUTO_INCREMENT,
    `youtube_channel` 	varchar(128) 	DEFAULT NULL,
    `hobby` 			varchar(45)		DEFAULT NULL,
    
    PRIMARY KEY (`id`)
)
	ENGINE=InnoDB 
	AUTO_INCREMENT=1 
	DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`(
	`id`					int(11)		NOT NULL AUTO_INCREMENT,
    `first_name`			varchar(45)	DEFAULT NULL,
    `last_name`				varchar(45)	DEFAULT NULL,
    `email`					varchar(45)	DEFAULT NULL,
    `instructor_detail_id`	int(11)		DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    KEY `FK_DETAIL_idx` (`instructor_detail_id`),					# what's this? 
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
		REFERENCES `instructor_detail` (`id`) 	
			ON DELETE NO ACTION 
			ON UPDATE NO ACTION
)
	ENGINE=InnoDB 
	AUTO_INCREMENT=1 
	DEFAULT CHARSET=latin1;
    
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
	`id`			int(11)			NOT NULL AUTO_INCREMENT,
    `title`			varchar(128)	DEFAULT NULL,
    `instructor_id`	int(11)			DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR`
		FOREIGN KEY (`instructor_id`)
		REFERENCES `instructor` (`id`)
			ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
	ENGINE=InnoDB
    AUTO_INCREMENT=1
    DEFAULT CHARSET=latin1;
    
    SET FOREIGN_KEY_CHECKS = 1;		# ??
    