USE getgo;
DROP table profile;
CREATE table profile(
	`id` int(5) primary key auto_increment,
	`student_id` varchar(40),
	`first_name` varchar(40),
	`last_name` varchar(40),
	`email` varchar(80),
	`city` varchar(40),
	`province` varchar(10),
	`country` varchar(10),
	`postal_code` varchar(10),
	`encrypted_password` varchar(40),
	`salt` varchar(30) not null,
	`created_at` datetime,
	`updated_at` datetime null,
);

