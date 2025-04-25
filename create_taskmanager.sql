drop schema if exists task_manager;

create schema task_manager;
use task_manager;

create table Subjects (
	ID_subject int not null auto_increment primary key,
    Name varchar (32) not null
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

insert into TaskTypes values
                          (1, 'Test'), (2, 'Homework'), (3, 'Others');

-- Insert models
insert into Subjects (Name) values
                                ('Art'), ('Biology'), ('Chemistry'), ('Databases'), ('English'),
                                ('Geography'), ('History'), ('Mathematics'), ('OOP'), ('Philosophy'),
                                ('Physical Education'), ('Physics'), ('Portuguese'), ('Sociology'),
                                ('Software Engineering'), ('Other');

-- Insert templates
insert into Tasks (ID_type, ID_subject, Descript, TaskDate) values 
																(1, 1, 'Art Test', '2025-05-05'), (2, 2, 'Biology Homework', '2025-10-11'), (3, 10, 'Philosophy Project', '2025-06-20');

create user if not exists 'java'@'localhost' identified by 'password';
grant all on task_manager.* to 'java'@'localhost';