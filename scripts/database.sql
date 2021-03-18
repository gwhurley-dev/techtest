create database techtest;

drop table techtest.enrollment;
drop table techtest.student;
drop table techtest.semester;
drop table techtest.course;

create table techtest.course
(
   `id` int not null auto_increment,
   `code` varchar(15) not null,
   `credits` int not null,
   primary key (`id`)
);
select id, code, credits from techtest.course;
insert into techtest.course (code, credits) values ('abc', 5);

create table techtest.semester
(
   `id` int not null auto_increment,
   `year` int not null,
   `semester` int not null,
   primary key (`id`)
);

create table techtest.student
(
   `id` int not null auto_increment,
   `firstName` varchar(45) not null,
   `lastName` varchar(45) not null,
   `nationality` varchar(45) not null,
   primary key (`id`)
);

create table techtest.enrollment
(
   `id` int not null auto_increment,
   `course_id` int not null,
   `semester_id` int not null,
   `student_id` int not null,
   primary key (`id`)
);
