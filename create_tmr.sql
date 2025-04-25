-- This schema will be used when I reorganize the project structure. It will probably have a login system and taskstatus per user.

drop schema if exists tmr;

create schema tmr;
use tmr;

create table Teachers (
                          ID_teacher int not null auto_increment primary key,
                          Name varchar (80) not null
);

create table Students (
                          ID_students int not null auto_increment primary key,
                          Name varchar (80) not null
);

create table Subjects (
                          ID_subject int not null auto_increment primary key,
                          ID_teacher int not null,
                          Name varchar (32) not null,

                          foreign key (ID_teacher) references Teachers (ID_teacher)
);

create table TaskTypes (
                           ID_type int not null auto_increment primary key,
                           Name varchar (16) not null
);

create table Tasks (
                       ID_task int not null auto_increment primary key,
                       ID_type int not null,
                       ID_subject int not null,
                       Descript varchar (64) not null,
                       TaskDate date not null,

                       foreign key (ID_type) references TaskTypes (ID_type),
                       foreign key (ID_subject) references Subjects (ID_subject)
);

create table TaskStatus (
                            ID_taskStatus int not null auto_increment primary key
);

insert into TaskTypes values
                          (1, 'Test'), (2, 'Homework'), (3, 'Others');

-- Insert models

insert into Teachers (Name) values ('The Teacher');
insert into Subjects (ID_teacher, Name) values
                                            (1, 'Art'), (1, 'Biology'), (1, 'Chemistry'), (1, 'Databases'), (1, 'English'),
                                            (1, 'Geography'), (1, 'History'), (1, 'Mathematics'), (1, 'OOP'), (1, 'Philosophy'),
                                            (1, 'Physical Education'), (1, 'Physics'), (1, 'Portuguese'), (1, 'Sociology'),
                                            (1, 'Software Engineering'), (1, 'Other');

create user if not exists 'java'@'localhost' identified by 'password';
grant all on tmr.* to 'java'@'localhost';