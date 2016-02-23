CREATE SCHEMA `advanse` ;

create table if not exists `roles` (
	id int unsigned not null auto_increment,
	role varchar(50) not null,
	primary key (id)
);

INSERT INTO `roles` (`id`, `role`) VALUES (NULL, 'student');

create table if not exists `users` (
	id int unsigned not null auto_increment,
	role_id int unsigned not null,
	name varchar(50) not null,
	id_num varchar(50) unique not null,
	password varchar(255) not null,
	datetime_joined datetime not null,
	foreign key (role_id) references roles (id),
	primary key (id)
);

create table if not exists `courses` (
	id int unsigned not null auto_increment,
	course_code varchar(50) not null,
	units float not null,
	max_students int not null,
	primary key (id) 
);

create table if not exists `enrollment` (
	course_id int unsigned not null,
	user_id int unsigned not null,
	foreign key (course_id) references courses (id),
	foreign key (user_id) references users (id)
);